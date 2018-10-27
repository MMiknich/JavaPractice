package mipt.student.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {

    @FindBy(css = "")
    private WebElement searchInputField;

    public void typeSearchTest(String text)
    {
        searchInputField.sendKeys(text);
    }
}
