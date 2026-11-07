# Storefront E2E Tests

![e2e](https://github.com/AntonVodolazskiy/storefront-e2e-selenium/actions/workflows/e2e.yml/badge.svg)

UI automation for an online store (Sauce Demo) using Java, Selenium WebDriver, and Cucumber with a BDD approach.

## What the Scenarios Cover

Against the [Sauce Demo](https://www.saucedemo.com/) storefront, a public demo site built for test automation:

1. **Login** – a valid user lands on the product catalog.
2. **Locked-out user** – login is rejected with a clear error message.
3. **Add to cart** – adding a product updates the cart badge.
4. **Checkout** – a full purchase from cart to the "Thank you for your order!" confirmation.

## BDD Structure

- Gherkin scenarios are defined in [storefront-shopping.feature](storefront-e2e-tests/src/test/resources/features/storefront-shopping.feature).
- The `Given`, `When`, `Then`, and `And` steps are implemented in [ShoppingFlowSteps.java](storefront-e2e-tests/src/test/java/e2e/steps/ShoppingFlowSteps.java).
- The Cucumber runner is located in [StorefrontE2ETest.java](storefront-e2e-tests/src/test/java/e2e/StorefrontE2ETest.java).
- [BrowserHooks.java](storefront-e2e-tests/src/test/java/e2e/hooks/BrowserHooks.java) initializes and closes the browser for each scenario.
- Page interaction is isolated in the Page Object: [StorefrontPage.java](storefront-e2e-tests/src/test/java/e2e/pages/StorefrontPage.java).

## Running the Tests

```zsh
cd storefront-e2e-tests
mvn clean test
```

To run in headless mode:

```zsh
mvn clean test -Dheadless=true
```
