package core;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebDriverListener implements WebDriverEventListener, ITestListener {

    private WebDriver driver;
    static Logger log = Logger.getLogger(WebDriverListener.class);

    public WebDriverListener(){
        super();
    }

    public WebDriverListener(WebDriver driver) {
            this.driver = driver;
        }

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        log.debug("Navigating to: " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        log.debug("Finding element: " + element);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        log.debug("Element is found: " + element);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        log.debug("Clicking on element: " + element);
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        log.debug("Changing value of element: " + element);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        log.debug("Element value has changed to: " + keysToSend);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        log.debug("Getting text of element: " + element);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        log.debug("Return element text: " + text);
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Start test: " + result.getName());
    }
}