package FinalProject.PO;

import net.serenitybdd.core.pages.WebElementDescriber;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ContactUsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Needed to use the @FindByMethods
    }

    @FindBy( xpath = "//*[@id=\"contact-link\"]")
    WebElement ContactUsMenu;

    @FindBy(xpath = "//*[@id=\"id_contact\"]")
    WebElement contactType;

    @FindBy(xpath = "//*[@id=\"email\"]")
    WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"id_order\"]")
    WebElement orderInput;

    @FindBy(xpath = "//span[class=\"action\"]")
    WebElement attachButton;

    @FindBy(xpath = "//*[@id=\"message\"]")
    WebElement messageArea;

    @FindBy(xpath = "//*[@id=\"fileUpload\"]")
    WebElement filename;

    @FindBy(xpath = "//*[@id=\"submitMessage\"]")
    WebElement submitButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p")
    WebElement ConfirmationMsg;

    public void ClickHeaderMenu(String Option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        switch(Option) {

            case "ContactUs":
                wait.until(ExpectedConditions.elementToBeClickable(ContactUsMenu));
                ContactUsMenu.click();
                break;
        }
    }

    public void FillSubjectHeading(String option) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Select select = new Select(contactType);
        select.selectByVisibleText("Customer service");
    }
    public void FillEmail(String strEmail) {
        emailInput.sendKeys(strEmail);
    }
    public void FillOrderReference(String strOrder){
        orderInput.sendKeys(strOrder);
    }
    public void FillMessageArea(String strMessage){
        messageArea.sendKeys(strMessage);
    }
public void FillFilePath(String strFilePath){
    filename.sendKeys(strFilePath);
}
public void clickOnSendButton(){
        submitButton.click();
}


    public void validateConfirmation() {
        String Confirmationlabel = "Your message has been successfully sent to our team.";
        String strConfirmation =  "";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(ConfirmationMsg));

        strConfirmation = ConfirmationMsg.getText();

        Assert.assertEquals(Confirmationlabel, strConfirmation);


    }
}
