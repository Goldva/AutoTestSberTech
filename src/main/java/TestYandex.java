import Elements.LaptopPage;
import Elements.MarketPage;
import Elements.YandexPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.DriverFactory;

import java.util.concurrent.TimeUnit;


public class TestYandex {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = DriverFactory.getDriver("chrome");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("http://www.yandex.ru");
    }

    @AfterClass
    public static void afterClass(){
        driver.close();
    }

    @Test
    public void testSearch() {
        YandexPage yandexPage = new YandexPage(driver);
        yandexPage.clickOnMarket();
        MarketPage marketPage = new MarketPage(driver);
        marketPage.moveToComputer();
        marketPage.clickToLaptop();
        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.sendKeyPriceFrom("20000");
        laptopPage.sendKeyPriceTo("25000");
        laptopPage.clickCheckBoxAcer();
        laptopPage.clickApply(driver);
        laptopPage.getNameProductFromList(1);
    }

//    @DataProvider
//    private Object[][] pageObjects() {
//        return new Object[][]{
//                {new YandexPage()},
//                {new MarketPage()}
//        };
//    }
//
//    @Test(dataProvider = "pageObjects")
//    public void testSearch(final ClickOnPage searchPage) {
//        searchPage.init(driver);
//        searchPage.clickOnMarket();
//    }

}
