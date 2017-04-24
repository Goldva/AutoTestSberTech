package Elements;

import Elements.interfaces.ClickOnPage;
import Elements.interfaces.SendKeyOnPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaptopPage implements SendKeyOnPage, ClickOnPage{
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/div/div[1]/div[2]/div[1]/span[1]")
    private WebElement priceFrom;
    @FindBy(id = "glf-priceto-var")
    private WebElement priceTo;


    @Override
    public void sendKey(String text) {
        priceFrom.sendKeys(text);
    }

    @Override
    public void click() {

    }

    @Override
    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
}
