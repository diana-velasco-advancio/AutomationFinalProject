package FinalProject.PO;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this); // Needed to use the @FindByMethods
    }
    @FindBy( xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    WebElement menuWomen;
    @FindBy( xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement menuDresses;
    @FindBy( xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
    WebElement menuTShirts;

    @FindBy( xpath = "//*[@id=\"block_top_menu\"]/ul/li[4]/a")
    WebElement menuBlog;

    @FindBy(xpath = "//*[@id=\"contact-link\"]")
    WebElement ContactUs;

    @FindBy(xpath = "//*[@id=\"layered_price_slider\"]/a[1]")
    WebElement priceSlider;

    @FindBy(id = "layered_price_range")
    WebElement RangeLabel;
    @FindBys({ @FindBy(className = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[1]/span")})
    List<WebElement> ProductPrice;

    @FindBys({ @FindBy(xpath = "//*[@class=\"product-image-container\"]")})
    List<WebElement> ProductImage;

    public void ClickMenu(String Option){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        switch(Option){

            case "women":
                wait.until(ExpectedConditions.elementToBeClickable(menuWomen));
                menuWomen.click();
                break;
            case "Dresses":
                wait.until(ExpectedConditions.elementToBeClickable(menuDresses));
                menuDresses.click();
                break;

            case "tshirts":
                wait.until(ExpectedConditions.elementToBeClickable(menuTShirts));
                menuTShirts.click();
                break;

            case "blog":
                wait.until(ExpectedConditions.elementToBeClickable(menuBlog));
                menuBlog.click();
                break;
        }
    }

    public void ClickOnHeaderMenu(String Option){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        switch(Option) {

            case "ContactUs":
                wait.until(ExpectedConditions.elementToBeClickable(ContactUs));
                ContactUs.click();
                break;

            case "SigIn":
                break;
        }
    }

    public void Setthefilter() {

        Actions action =  new Actions(driver);
        action.dragAndDropBy(priceSlider, 50, 0).perform();

    }

    public void ValidatePriceFilter() {
        Float Price, lowLimit, topLimit;
        Boolean TestPassed = true;

        lowLimit = Float.parseFloat(RangeLabel.getText().substring(1,6));
        topLimit = Float.parseFloat(RangeLabel.getText().substring(10,14));

        if(null != ProductPrice && ProductPrice.size() > 0){
            for(int i = 0; i<ProductPrice.size(); i++){
                WebElement labelPrice = ProductPrice.get(i);
                Price = Float.parseFloat(labelPrice.getText());

                if (Price<lowLimit || Price > topLimit){
                    TestPassed = false;
                }

                Assert.assertTrue("Test Failed", TestPassed);

            }
        }
    }

    public void addProduct() {
        if (null != ProductImage && ProductImage.size() > 0) {

                WebElement productBox = ProductImage.get(1);
                productBox.click();

        }
    }
  /*  public void addAllProductsWithADiscount() {
        if(null != ProductContainer && ProductContainer.size() > 0){
            for(int i = 0; i<ProductContainer.size(); i++){
                WebElement productBox = ProductContainer.get(i);

                WebElement discountLabel = productBox.findElement(By.xpath("//span[@class=\"price-percent-reduction\"]"));
               //WebElement addToCartButton = productBox.findElement(By.xpath("//a[@class=\"ajax_add_to_cart_button\"]"));
                //ajax_add_to_cart_button
                //price-percent-reduction

                Actions action =  new Actions(driver);

                if (null != discountLabel) {
                    action.moveToElement(discountLabel).perform();
                    wait.until(ExpectedConditions.elementToBeClickable(discountLabel));
                    discountLabel.click();
                }

            }
        }
    }*/


}
