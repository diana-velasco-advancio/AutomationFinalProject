package FinalProject.steps;

import FinalProject.PO.ContactUsPage;
import FinalProject.driver.DriverManager;
import io.cucumber.java.en.Then;

public class ContactUsSteps extends DriverManager {
    ContactUsPage contactUsPage = new ContactUsPage(driver);

    @Then("I fill Subject Heading with {string}")
    public void iFillSubjectHeadingWith(String option) {
        contactUsPage.FillSubjectHeading(option);
    }
   @Then("I fill email with {string}")
    public void iFillEmailWith(String strEmail) {
        contactUsPage.FillEmail(strEmail);
    }
    @Then("I fill order reference with {string}")
    public void iFillOrderReference(String strOrder) {
        contactUsPage.FillOrderReference(strOrder);
    }
    @Then("I fill Message Area with {string}")
    public void iFillMessageArea(String strText) {
        contactUsPage.FillMessageArea(strText);
    }

    @Then("I fill Selection File with {string}")
        public void iFillFile(String strFilepath) {
        contactUsPage.FillFilePath(strFilepath);
    }

    @Then("I click on Send button")
    public void iClickonSendButton(){
        contactUsPage.clickOnSendButton();
    }

    @Then("I validate the data was sent correctly")
    public void iValidateTheDataWasSentCorrectly() {
        contactUsPage.validateConfirmation();
    }
}
