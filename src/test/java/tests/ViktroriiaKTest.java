package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.StartPage;
import pages.TopListPage;
import runner.BaseTest;

public class ViktroriiaKTest extends BaseTest {

    private static final String BASE_URL = "https://www.99-bottles-of-beer.net/";

    @Test
    public void CheckStartMenuHeader2() {

        String expectedResult = "Welcome to 99 Bottles of Beer";

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//div[@id='main']/h2")).getText();

        Assert.assertEquals(getDriver().findElement(By.xpath("//div[@id='main']/h2")).getText(), expectedResult);
    }

    @Test
    public void checkTopListMenuTopHits() {

        String expectedResult = "Top Hits";

        getDriver().get(BASE_URL);

        MainPage mainPage = new MainPage(getDriver());

        mainPage.clickTopListMenu();

        TopListPage hits = new TopListPage(getDriver());
        hits.clickMenuTopHits();

        String actualResult = hits.getMenuTopHitsText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void menuStartMenuHistory() {

        String expectedResult = "https://www.99-bottles-of-beer.net/images/history1_full.png";

        getDriver().get(BASE_URL);

        StartPage startPage = new StartPage(getDriver());

        startPage.getHistoryMenuClick();

        getDriver().findElement(By.xpath("//div[@id='main']/p/a/img[@src='/images/history1_small.png']")).click();

        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResult);

    }
}

