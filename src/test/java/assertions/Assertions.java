package assertions;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pages.HomePage;

public class Assertions {

    static Logger log = Logger.getLogger(Assertions.class);

    HomePage homePage;

    @Step
    public void AssertThatSelectedPopularTagIsPresent(String tag){
        Assert.assertTrue(homePage.isPopularTagSelected(tag));
    }

    @Step
    public void AssertThatArticlesWithSelectedPopularTagPresent(String tag){
        Assert.assertEquals(
                homePage.findArticlesByTag(tag).size(),
                homePage.findAllArticlesOnPAge().size()
        );

    }

    @Step
    public void AssertThatAllArticlesWithSelectedPopularTagPresent(String tag){
        int page = 1;
        int articleCount = 0;
        int articleWithTagCount = 0;

        homePage.clickFirstPage();

        while(page <= homePage.getPageCount()) {
            articleCount += homePage.findAllArticlesOnPAge().size();
            articleWithTagCount += homePage.findArticlesByTag(tag).size();
            homePage.clickNextPage();
            page++;
        }
        log.info("articleCount: " + articleCount + ", articleWithTagCount: " + articleWithTagCount);
        Assert.assertEquals(articleCount, articleWithTagCount);
    }

    public Assertions(HomePage homePage){
        this.homePage = homePage;
    }
}
