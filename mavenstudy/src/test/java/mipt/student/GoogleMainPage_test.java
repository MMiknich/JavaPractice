package mipt.student;

import mipt.student.data.BrowserData;
import mipt.student.drivers.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage_test {

    private WebDriver driver = null;
    BrowserData browserData = new BrowserData();

    @Before
    public void init()
    {
        driver =  WebDriverFactory.getWebDriverInstance(browserData);
    }
    @After
    public void killBrowser(){
        driver.close();
        driver.quit();
    }

    @Test
    public void type_text_in_search_field_check_counter(){
        driver.get("https://google.ru");
    }
}
