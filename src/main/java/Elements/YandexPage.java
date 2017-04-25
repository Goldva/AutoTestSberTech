package Elements;

import Elements.interfaces.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YandexPage extends Page {
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/div/a[2]")
//    @FindBy(linkText = "Маркет")
    private WebElement market;

    public YandexPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void clickOnMarket() {
        market.click();
    }

//    @Override
//    public void init(final WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
}
