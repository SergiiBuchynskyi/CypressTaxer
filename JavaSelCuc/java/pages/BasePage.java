package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

abstract public class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//div[text()='Search']")
    public WebElement search;
    @FindBy(xpath = "//div[text()='Search']")
    public WebElement updates;
    @FindBy(xpath = "//div[text()='Settings & members']")
    public WebElement settingsMembers;
    @FindBy(xpath = "//div[text()='New page']")
    public WebElement newPage;
    @FindBy(xpath = "//div[text()='Getting Started']")
    public WebElement gettingStarted;
    @FindBy(xpath = "//div[text()='Quick Note']")
    public WebElement quickNote;
    @FindBy(xpath = "//div[text()='Personal Home']")
    public WebElement personalHome;
    @FindBy(xpath = "//div[text()='Task List']")
    public WebElement taskList;
    @FindBy(xpath = "//div[text()='Journal']")
    public WebElement journal;
    @FindBy(xpath = "//div[text()='Reading List']")
    public WebElement readingList;
    @FindBy(xpath = "//div[text()='Add a page']")
    public WebElement addApage;
    @FindBy(xpath = "//div[text()='Create a teamspace']")
    public WebElement createAteamspace;
    @FindBy(xpath = "//div[text()='Templates']")
    public WebElement templates;
    @FindBy(xpath = "//div[text()='Import']")
    public WebElement importBtn;
    @FindBy(xpath = "//div[text()='Trash']")
    public WebElement trash;


   

}
