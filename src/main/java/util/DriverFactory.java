package util;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverFactory {
    public static WebDriver getDriver(String browser){
        if (browser.equals("chrome")){
            ChromeDriverManager.getInstance().setup();
            return new ChromeDriver();
        }else if (browser.equals("firefox")){
            FirefoxDriverManager.getInstance().setup();
            return new FirefoxDriver();
        }else if (browser.equals("ie")) {
            InternetExplorerDriverManager.getInstance().setup();
            DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
            ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            return new InternetExplorerDriver(ieCapabilities);
        }else if (browser.equals("opera")){
            OperaDriverManager.getInstance().setup();
            return new OperaDriver();
        }
        return null;
    }
}
