package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class DriverSetup {

    protected WebDriver wDriver;
    protected EventFiringWebDriver driver;
    protected WebDriverListener listener;

    public WebDriver setUpWebDriver() {
        String browserName = System.getProperty("BROWSER");

        try {
            switch (browserName.toUpperCase()) {
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    wDriver = new FirefoxDriver();
                    driver = new EventFiringWebDriver(wDriver);
                    listener = new WebDriverListener(wDriver);
                    driver.register(listener);
                    break;

                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    wDriver = new ChromeDriver();
                    driver = new EventFiringWebDriver(wDriver);
                    listener = new WebDriverListener(wDriver);
                    driver.register(listener);
            }
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println("Failed to create Driver for " + browserName);
            System.out.println(e.getMessage());
        }
        return driver;
    }

    public void tearDownWebDriver(){
        try {
            driver.quit();
        }catch (Exception e){
            System.out.println("Cannot quit driver, cause: " + e.getMessage());
        }
    }
    public WebDriver getDriver(){
        return setUpWebDriver();
    }
}
