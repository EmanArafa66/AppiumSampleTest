package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By cartItem = By.className("cart_item");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemInCart() {
        return driver.findElements(cartItem).size() > 0;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}