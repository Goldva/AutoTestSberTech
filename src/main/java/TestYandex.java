import Elements.YandexMarket;
import Elements.interfaces.ClickOnPage;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestYandex {
    private static WebDriver driver;

    @BeforeClass
    public static void beforeClass(){
//        ChromeDriverManager.getInstance().setup();
//        driver = new ChromeDriver();
        InternetExplorerDriverManager.getInstance().setup();
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);

        ieCapabilities.setVersion("9");
        driver = new InternetExplorerDriver(ieCapabilities);

    }

    @AfterClass
    public static void afterClass(){
        driver.close();
    }

    @DataProvider
    private Object[][] pageObjects() {
        return new Object[][]{
                {new YandexMarket()}
        };
    }


    @Test(dataProvider = "pageObjects")
    public void testSearch(final ClickOnPage searchPage) {
        driver.navigate().to("http://www.yandex.ru");
//        driver.get("http://www.yandex.ru");
        driver.manage().window().maximize();

        searchPage.init(driver);
        searchPage.click();
    }

}
