package Elements;

import Elements.interfaces.ClickOnPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class YandexPage implements ClickOnPage {
    @FindBy(xpath = "/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/div/a[2]")
    private WebElement market;

    @Override
    public void click() {
        market.click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
