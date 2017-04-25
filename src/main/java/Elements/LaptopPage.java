package Elements;

import Elements.interfaces.Page;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LaptopPage extends Page{
    @FindBy(id = "glf-pricefrom-var")
    private WebElement priceFrom;
    @FindBy(id = "glf-priceto-var")
    private WebElement priceTo;
    @FindBy(id = "glf-7893318-267101")
    private WebElement checkAcer;
    @FindBy(xpath = "/html/body/div[1]/div[4]/div[2]/div[2]/div[1]/div/div[31]/div[1]/button")
    private WebElement buttonApply;
    @FindBys({@FindBy(className = "snippet-card__header-text")})
    private List<WebElement> listProducts;


    public LaptopPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void sendKeyPriceFrom(String text) {
        action.moveToElement(priceFrom);
        action.click();
        action.sendKeys(text);
        action.perform();
    }

    public void sendKeyPriceTo(String text) {
        action.moveToElement(priceTo);
        action.click();
        action.sendKeys(text);
        action.perform();
    }

    public void clickCheckBoxAcer(){
        action.click(checkAcer);
        action.perform();
    }

    public void clickApply(WebDriver driver){
        int y = buttonApply.getLocation().getY();
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+y+");");
        action.click(buttonApply);
        action.perform();
        wait.until(ExpectedConditions.invisibilityOf(listProducts.get(0)));
    }

    public String getNameProductFromList(int indexProduct){
        String result = listProducts.get(indexProduct).getText();
        return result;
    }
}
