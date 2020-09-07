package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;
import java.util.stream.Collectors;

@FindBy(tagName = "article-preview")
public class Article extends HtmlElement {

    @FindBy(className = "author")
    WebElement author;

    @FindBy(className = "date")
    WebElement date;

    @FindBy(tagName = "favorite-btn")
    WebElement favorite;

    @FindBy(tagName = "h1")
    WebElement title;

    @FindBy(tagName = "p")
    WebElement description;

    @FindBy(xpath = "//ul[@class = 'tag-list']/li")
    List<WebElement> tags;

    public String getAuthor(){
        return author.getText().trim();
    }

    public String getDate(){
        return date.getText().trim();
    }

    public int getFavoriteCount(){
        return Integer.parseInt(
                favorite.getText().trim());
    }

    public void clickFavorite(){
        favorite.click();
    }

    public String getTitle(){
        return title.getText().trim();
    }

    public String getDescription(){
        return description.getText().trim();
    }

    public List<String> getTags(){
        return tags.stream()
                .map(
                        e -> e.getText().trim())
                .collect(Collectors.toList());
    }
}
