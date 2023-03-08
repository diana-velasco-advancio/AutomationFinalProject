package FinalProject.steps;

import FinalProject.driver.DriverManager;

import FinalProject.PO.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;
public class HomeSteps extends DriverManager {
    HomePage homepage = new HomePage(driver);

    @Then("I click on Menu {string}")
    public void iClickOnMenu(String strOpt) {
        homepage.ClickMenu(strOpt);
    }

    @Then("I set the filter price")
    public void iSetTheFilterPrice() {
        homepage.Setthefilter();
    }

    @Then("I validate the price filter works")
    public void iValidateThePriceFilter() {
        homepage.ValidatePriceFilter();
    }

    @Then("I add all products with a discount")
    public void iAddAllProductsWithADiscount() {
        //homepage.addAllProductsWithADiscount();
    }

    @Then("I add a product")
    public void iAddAProduct() {
        homepage.addProduct();
    }

    @Then("I click on HeaderMenu {string}")
    public void iClickOnHeaderMenu(String Option) {
        homepage.ClickOnHeaderMenu(Option);
    }

}
