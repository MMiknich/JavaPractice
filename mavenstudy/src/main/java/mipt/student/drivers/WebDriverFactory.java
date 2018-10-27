package mipt.student.drivers;

import mipt.student.data.BrowserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    public WebDriver getWebDriverInstance(BrowserData browser)
    {
        switch (browser.type) {
            case "chrome":
                return new ChromeDriver();
            default:
                return null;
        }
    }

    private void ChromeOptions getBaseChromeOptions(){
        ChromeOptions chromeOptions = new ChromeOptions()
    }
}
