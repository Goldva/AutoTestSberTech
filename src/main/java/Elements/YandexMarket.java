package Elements;

import Elements.interfaces.ClickOnPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class YandexMarket implements ClickOnPage {
//    @FindBy(tagName = "tabs.market")
//    @FindBy(linkText = "Маркет")
    private List<WebElement> market;

    @Override
    public void click() {
        market.get(0).click();
    }

    @Override
    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
        market = driver.findElements(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div/div[2]/div/div[1]/div/a[2]"));
    }
}
