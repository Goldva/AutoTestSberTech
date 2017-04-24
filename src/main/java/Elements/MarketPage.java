package Elements;

import Elements.interfaces.ClickOnPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MarketPage implements ClickOnPage{
    private Actions action;
    private Wait<WebDriver> wait;

    @FindBys({
            @FindBy(className = "topmenu__item")
    })
    private List<WebElement> listTopMenu;

    @FindBy(className = "topmenu__subitem_nid_54545 ")
    private WebElement laptop;

    @Override
    public void click() {
        for (WebElement element : listTopMenu) {
            if (element.getText().equals("Компьютеры")) {
                action.moveToElement(element);
                action.perform();
            }
        }

        wait.until(ExpectedConditions.visibilityOf(laptop));
        laptop.click();

    }

    @Override
    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
        wait = new FluentWait<WebDriver>(driver).withMessage("Element was not found").withTimeout(10, TimeUnit.SECONDS);
    }
}
