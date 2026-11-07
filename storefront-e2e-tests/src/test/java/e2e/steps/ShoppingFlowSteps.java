package e2e.steps;

import e2e.pages.StorefrontPage;
import e2e.support.WebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingFlowSteps {
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private StorefrontPage storefrontPage;

    @Given("I am on the Sauce Demo login page")
    public void openLoginPage() {
        storefrontPage = new StorefrontPage(WebDriverManager.getDriver());
        storefrontPage.open(BASE_URL);
    }

    @When("I log in as {string} with password {string}")
    public void logIn(String username, String password) {
        storefrontPage.logIn(username, password);
    }

    @Then("I should see the product catalog")
    public void verifyCatalog() {
        storefrontPage.assertCatalogIsVisible();
    }

    @Then("I should see the login error {string}")
    public void verifyLoginError(String message) {
        storefrontPage.assertLoginError(message);
    }

    @When("I add the first product to the cart")
    public void addFirstProduct() {
        storefrontPage.addFirstProductToCart();
    }

    @Then("the cart badge should show {int} item")
    public void verifyCartBadge(int count) {
        storefrontPage.assertCartCount(count);
    }

    @When("I check out as {string} {string} with postal code {string}")
    public void checkOut(String firstName, String lastName, String postalCode) {
        storefrontPage.checkOut(firstName, lastName, postalCode);
    }

    @Then("I should see the order confirmation")
    public void verifyConfirmation() {
        storefrontPage.assertOrderConfirmed();
    }
}
