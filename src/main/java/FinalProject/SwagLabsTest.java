package FinalProject;

import FinalProject.driver.DriverManager;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class SwagLabsTest {
    private WebDriver driver;

    DriverManager driverManager = new DriverManager();

    @Before
    public void iniDriver() {
        driverManager.initDriver();
        driver = ThucydidesWebDriverSupport.getDriver();
    }

    @Test
    public void login() {
        driver.get("http://automationpractice.pl/index.php");
    }

    @After
    public void closeBrowser() {
        driverManager.quitBrowser();
    }
}