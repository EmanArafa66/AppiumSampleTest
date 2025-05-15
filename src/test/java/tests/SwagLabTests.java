package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import utils.DriverFactory;

public class SwagLabTests {

    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test(priority = 1)
    public void testValidLogin() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(productsPage.getTitleText(), "Products");
    }

    @Test(priority = 2)
    public void testAddProductToCart() {
        productsPage.addFirstProductToCart();
        Assert.assertEquals(productsPage.getCartBadgeText(), "1");
    }

    @Test(priority = 3)
    public void testLogout() {
        productsPage.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo")); // Should land back on login
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}