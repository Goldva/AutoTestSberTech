package Elements.interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.concurrent.TimeUnit;

public abstract class Page {
    protected static Actions action;
    protected static Wait<WebDriver> wait;

    public Page(WebDriver driver) {
        if (action == null || wait == null) {
            action = new Actions(driver);
            wait = new FluentWait<WebDriver>(driver).withMessage("Element was not found").withTimeout(10, TimeUnit.SECONDS);
        }
    }

}
