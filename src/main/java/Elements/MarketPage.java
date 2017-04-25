package Elements;

import Elements.interfaces.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MarketPage extends Page{
    @FindBys({@FindBy(className = "topmenu__item")})
    private List<WebElement> listTopMenu;
    @FindBy(className = "topmenu__subitem_nid_54545 ")
    private WebElement laptop;

    public MarketPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void moveToComputer() {
        for (WebElement element : listTopMenu) {
            if (element.getText().equals("Компьютеры")) {
                action.moveToElement(element);
                action.perform();
            }
        }
    }

    public void clickToLaptop() {
        wait.until(ExpectedConditions.visibilityOf(laptop));
        laptop.click();
    }
}
