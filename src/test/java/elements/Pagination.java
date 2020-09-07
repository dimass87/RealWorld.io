package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@FindBy(tagName = "list-pagination")
public class Pagination extends HtmlElement {

    @FindBy(tagName = "a")
    private List<WebElement> pages;

    @FindBy(css = ".page-item.ng-scope.active")
    private WebElement currentPage;

    @FindBy(xpath = "//li[@class = 'page-item ng-scope active']/following-sibling::li")
    private List<WebElement> following;

    public List<WebElement> getPages(){
        return  pages;
    }

    public WebElement getCurrentPage(){
        return currentPage;
    }

    public boolean hasNext(){
        return currentPage.findElements(
                By.xpath("./following-sibling::li"))
                .size() > 0;
    }

    public boolean hasPrevious(){
        return currentPage.findElements(
                By.xpath("./preceding-sibling::li"))
                .size() > 0;
    }

    public WebElement getFollowing(){
       return following.get(0);
    }

    public boolean isFirst(){
        return currentPage.getText().trim().equals("1");
    }
}
