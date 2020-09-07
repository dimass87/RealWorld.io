package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverExtension extends DriverSetup{

    private static final int EXPLICIT_WAIT_TIME = 15;

    WebDriver driver;
    protected WebElement waitForElementToClick(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public int waitForListElement(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elementList.size();
    }

    public WebElement waitForElementIsVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
    }

    public void scrollIntoView(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebDriver getWebDriver(){
        this.driver = setUpWebDriver();
        return driver;
    }
}
