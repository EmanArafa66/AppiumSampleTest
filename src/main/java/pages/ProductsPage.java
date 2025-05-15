package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;

    private By productsTitle = By.className("title");
    private By addToCartButton = By.xpath("//button[contains(text(),'Add to cart')]");
    private By shoppingCartBadge = By.className("shopping_cart_badge");
    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutSidebar = By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitleText() {
        return driver.findElement(productsTitle).getText();
    }

    public void addFirstProductToCart() {
        driver.findElement(addToCartButton).click();
    }

    public String getCartBadgeText() {
        return driver.findElement(shoppingCartBadge).getText();
    }

    public void logout() {
        driver.findElement(menuButton).click();
        driver.findElement(logoutSidebar).click();
    }
}