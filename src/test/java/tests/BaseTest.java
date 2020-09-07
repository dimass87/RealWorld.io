package tests;

import core.DriverSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest{

    WebDriver driver;
    DriverSetup ds = new DriverSetup();

    @BeforeClass
    public void beforeClass(){
       driver = ds.getDriver();
    }
    @AfterClass
    public void afterClass(){ ds.tearDownWebDriver(); }
}
