package tests;

import assertions.Assertions;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;

public class FindArticlesByPopularTagTest extends BaseTest{

    private HomePage homePage;
    private Assertions assertions;

    @BeforeClass
    public void setUp(){
        homePage = new HomePage(driver);
        assertions = new Assertions(homePage);
    }
    
    @Parameters("tag1")
    @Test(groups = {"Smoke"}, priority = 1)
    @Description("Test that selected popular tag is appears near the Global Feed tab")
    public void selectedPopularTagPresentTest(String tag1){
        homePage.navigateTo();
        homePage.selectPopularTag(tag1);
        assertions.AssertThatSelectedPopularTagIsPresent(tag1);
    }

    @Parameters({"tag1", "tag2"})
    @Test(groups = {"Regression"}, priority = 2)
    @Description("Test that last selected popular tag is appears near the Global Feed tab")
    public void lastSelectedPopularTagPresentTest(String tag1, String tag2){
        homePage.navigateTo();
        homePage.selectPopularTag(tag1);
        homePage.selectPopularTag(tag2);
        assertions.AssertThatSelectedPopularTagIsPresent(tag2);
    }

    @Parameters("tag1")
    @Test(groups = {"Smoke"}, priority = 3)
    @Description("Test that only articles with selected popular tag are present on current page")
    public void OnlyArticlesWithSelectedPopularTagPresentTest(String tag1){
        homePage.navigateTo();
        homePage.selectPopularTag(tag1);
        assertions.AssertThatArticlesWithSelectedPopularTagPresent(tag1);
    }

//    @Parameters("tag1")
//    @Test(groups = {"Regression"}, priority = 4)
//    @Description("Test that only articles with selected popular tag are present on all pages")
//    public void OnlyArticlesWithSelectedPopularTagPresentOnAllPagesTest(String tag1){
//        homePage.navigateTo();
//        homePage.selectPopularTag(tag1);
//        assertions.AssertThatAllArticlesWithSelectedPopularTagPresent(tag1);
//    }
}
