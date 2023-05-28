package step_Definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.Taxer;
import utilities.BrowserUtils;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.io.File;
import java.util.List;

public class TaxerStepDef {
    Taxer taxer = new Taxer();
    int quantityOfCertAdded;
    int quantityOfSavedCert;
    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        Driver.getDriver().get(ConfigurationReader.getProperty(url));
        try {
            taxer.startProj.click();
        } catch (Exception e) {

        }
    }

    @When("user click AddBtn")
    public void user_click_add_btn() {
        taxer.addCert.click();
    }

    @When("add certificates")
    public void add_certificates() {

        String folderPath = "C:\\Users\\buchi\\Desktop\\test_certs\\";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        String JS_DROP_FILE =
                "var target = arguments[0]," +
                        "    offsetX = arguments[1]," +
                        "    offsetY = arguments[2]," +
                        "    document = target.ownerDocument || document," +
                        "    window = document.defaultView || window;" +
                        "var input = document.createElement('INPUT');" +
                        "input.type = 'file';" +
                        "input.style.display = 'none';" +
                        "input.onchange = function () {" +
                        "  var rect = target.getBoundingClientRect()," +
                        "      x = rect.left + (offsetX || (rect.width >> 1))," +
                        "      y = rect.top + (offsetY || (rect.height >> 1))," +
                        "      dataTransfer = { files: this.files };" +
                        "  ['dragenter', 'dragover'].forEach(function (name) {" +
                        "    var evt = document.createEvent('MouseEvent');" +
                        "    evt.initMouseEvent(name, true, true, window, 0, 0, 0, x, y, false, false, false, false, 0, null);" +
                        "    evt.dataTransfer = dataTransfer;" +
                        "    target.dispatchEvent(evt);" +
                        "  });" +
                        "  var dropEvt = document.createEvent('CustomEvent');" +
                        "  dropEvt.initCustomEvent('drop', true, true, null);" +
                        "  dropEvt.dataTransfer = dataTransfer;" +
                        "  target.dispatchEvent(dropEvt);" +
                        "  setTimeout(function () { document.body.removeChild(input); }, 25);" +
                        "};" +
                        "document.body.appendChild(input);" +
                        "return input;";

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String filePath = file.getAbsolutePath();
                    WebElement input = (WebElement) js.executeScript(JS_DROP_FILE, taxer.drobBox, 0, 0);
                    input.sendKeys(filePath);
                    BrowserUtils.waitForVisibility(taxer.addCert,5);
                    try {
                        taxer.addCert.click();
                    } catch (Exception e) {
                        System.out.println("Files added");
                    }
                }
            }
        }
    }



    @Then("certificate should be displayed")
    public void certificate_should_be_displayed() {
        BrowserUtils.waitForPageToLoad(5);
        quantityOfCertAdded = Driver.getDriver().findElements(By.xpath("//a")).size();
        System.out.println("quantityOfCertAdded = " + quantityOfCertAdded);
        Assert.assertTrue(quantityOfCertAdded>0);

    }

    @And("refresh page")
    public void refreshPage() {
        BrowserUtils.waitFor(2);
        quantityOfCertAdded = Driver.getDriver().findElements(By.xpath("//a")).size();
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("certificate should be saved")
    public void certificateShouldBeSaved() {
        quantityOfSavedCert = Driver.getDriver().findElements(By.xpath("//a")).size();
        System.out.println("quantityOfSavedCert = " + quantityOfSavedCert);
        Assert.assertEquals(quantityOfCertAdded,quantityOfSavedCert);
    }
}
