package e2e.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorefrontPage {
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static final By USERNAME = By.id("user-name");
    private static final By PASSWORD = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By LOGIN_ERROR = By.cssSelector("[data-test='error']");
    private static final By INVENTORY_ITEMS = By.cssSelector(".inventory_item");
    private static final By ADD_TO_CART = By.cssSelector(".inventory_item button[id^='add-to-cart']");
    private static final By CART_BADGE = By.cssSelector(".shopping_cart_badge");
    private static final By CART_LINK = By.cssSelector(".shopping_cart_link");
    private static final By CHECKOUT_BUTTON = By.id("checkout");
    private static final By FIRST_NAME = By.id("first-name");
    private static final By LAST_NAME = By.id("last-name");
    private static final By POSTAL_CODE = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By COMPLETE_HEADER = By.cssSelector(".complete-header");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public StorefrontPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void open(String url) {
        driver.get(url);
        visible(LOGIN_BUTTON);
    }

    public void logIn(String username, String password) {
        type(USERNAME, username);
        type(PASSWORD, password);
        click(LOGIN_BUTTON);
    }

    public void assertCatalogIsVisible() {
        wait.until(ExpectedConditions.urlContains("inventory"));
        Assertions.assertFalse(wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(INVENTORY_ITEMS)).isEmpty(),
                "Expected the product catalog to list items.");
    }

    public void assertLoginError(String expected) {
        Assertions.assertTrue(visible(LOGIN_ERROR).getText().contains(expected),
                "Expected login error containing: " + expected);
    }

    public void addFirstProductToCart() {
        click(ADD_TO_CART);
    }

    public void assertCartCount(int expected) {
        Assertions.assertEquals(String.valueOf(expected), visible(CART_BADGE).getText());
    }

    public void checkOut(String firstName, String lastName, String postalCode) {
        click(CART_LINK);
        click(CHECKOUT_BUTTON);
        type(FIRST_NAME, firstName);
        type(LAST_NAME, lastName);
        type(POSTAL_CODE, postalCode);
        click(CONTINUE_BUTTON);
        click(FINISH_BUTTON);
    }

    public void assertOrderConfirmed() {
        Assertions.assertEquals("Thank you for your order!", visible(COMPLETE_HEADER).getText());
    }

    private void type(By locator, String value) {
        WebElement input = visible(locator);
        input.clear();
        input.sendKeys(value);
    }

    private void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    private WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
