package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

public class BasePage {

    protected WebDriver driver;
    private static final int EXPLICIT_WAIT_TIME = 30;

    protected WebElement waitForElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected int waitForListElement(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elementList.size();
    }

    protected void waitForElementIsInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }

    protected void scrollIntoView(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected BasePage(WebDriver driver) {
        PageFactory.initElements(
                new HtmlElementDecorator(
                        new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }
}
