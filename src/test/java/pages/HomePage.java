package pages;

import elements.Article;
import elements.Pagination;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage{

    static Logger log = Logger.getLogger(HomePage.class);

    String URL = "https://demo.realworld.io";
    private List<Article> articles;
    private Pagination pagination;

    @FindBy(className = "banner")
    private WebElement banner;

    @FindBy(xpath = "//a[contains(normalize-space(), 'Global Feed')]")
    private  WebElement globalFeed;

    @FindBy(css = ".nav-link.active.ng-binding")
    private  WebElement selectedTag;

    @FindBy(xpath = "//article-preview/")
    private List<WebElement> articleTags;

    @FindBy(css = ".tag-default.tag-pill.ng-binding.ng-scope")
    private  List<WebElement> popularTagList;

    @FindBy(xpath = "//div[contains(text(),'Loading articles...')]")
    private WebElement loadingArticles;

    @FindBy(xpath = "//div[contains(text(),'Loading tags...')]")
    private WebElement loadingTags;

    public boolean isPopularTagSelected(String tag){
        return selectedTag.getText().trim().equals(tag);
    }

    public List<Article> findAllArticlesOnPAge(){
        log.info("HomePage.findAllArticlesOnPAge()");
        return articles;
    }

    @Step
    public List<Article> findArticlesByAuthor(String author){
        log.info("HomePage.findArticlesByAuthor()");
        return  articles.stream()
                .filter(
                        e -> e.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Step
    public List<Article> findArticlesByTag(String tag){
        log.info("HomePage.findArticlesByTag()");
        return  articles.parallelStream()
                .filter(
                        e -> e.getTags().contains(tag))
                .collect(Collectors.toList());
    }

    @Step
    public void selectPopularTag(String tag){
        log.info("HomePage.selectPopularTag()");
        waitForElementIsInvisible(loadingTags);
        try {
            popularTagList.stream()
                    .filter(
                            e -> e.getText().trim().equals(tag))
                    .findFirst()
                    .get()
                    .click();
        }
        catch (NullPointerException e){
            log.error("Element with tag " + tag + " not found");
        }

    }

    public void clickFirstPage(){
        log.info("HomePage.clickFirstPage()");
        if (!pagination.isFirst()) {
            scrollIntoView(pagination.getCurrentPage());
            pagination.getPages().stream()
                    .filter(
                            e -> e.getText().trim().equals("1"))
                    .forEach(WebElement::click);
        }
    }

    public void clickNextPage(){
        log.info("HomePage.clickNextPage()");
        if (pagination.hasNext()){
            scrollIntoView(pagination.getCurrentPage());
            pagination.getCurrentPage()
                    .findElements(By.xpath("./following-sibling::li/a"))
                    .get(0)
                    .click();
            waitForElementIsInvisible(loadingArticles);
        }
    }

    public void clickPreviousPage(){
        log.info("HomePage.clickPreviousPage()");
        if (pagination.hasPrevious()) {
            scrollIntoView(pagination.getCurrentPage());
            pagination.getCurrentPage().findElements(
                    By.xpath("./preceding-sibling::li/a"))
                    .get(1)
                    .click();
        }
    }

    public int getPageCount(){
        int result = pagination.getPages().size();
        log.info("HomePage.getPageCount() -> return: "+result);
        return result;
    }

    @Step
    public void navigateTo() {
        log.info("HomePage.navigateTo(): "+URL);
        driver.navigate().to(URL);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        waitForElementIsInvisible(loadingTags);
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
}
