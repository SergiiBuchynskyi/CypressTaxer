package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Taxer extends BasePage {

    @FindBy(css = ".btn.btn-primary")
    public WebElement addCert;

    @FindBy(css = ".dropbox.ng-isolate-scope")
    public WebElement drobBox;

    @FindBy(xpath = "//button[@onclick='__runProject()']")
    public WebElement startProj;
    @FindBy(xpath = "//a")
    public WebElement listOfCert;


}
