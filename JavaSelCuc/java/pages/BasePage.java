package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

abstract public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
