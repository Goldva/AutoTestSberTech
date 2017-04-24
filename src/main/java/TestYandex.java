import Elements.LaptopPage;
import Elements.MarketPage;
import Elements.YandexPage;
import Elements.interfaces.ClickOnPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.DriverFactory;


public class TestYandex {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
        driver = DriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://www.yandex.ru");
    }

    @AfterClass
    public static void afterClass(){
        driver.close();
    }

    @Test
    public void testSearch() {
        ClickOnPage clickOnPage = new YandexPage();
        clickOnPage.init(driver);
        clickOnPage.click();
        clickOnPage = new MarketPage();
        clickOnPage.init(driver);
        clickOnPage.click();
        LaptopPage laptopPage = new LaptopPage();
        laptopPage.init(driver);
        laptopPage.sendKey("111111");
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
//        searchPage.click();
//    }

}
