# Storefront E2E Tests

![e2e](https://github.com/AntonVodolazskiy/storefront-e2e-selenium/actions/workflows/e2e.yml/badge.svg)

UI automation for an online store using Java, Selenium WebDriver, and Cucumber with a BDD approach.

## What the Scenarios Cover

Against the cadeaubon.nl storefront:

1. **Search autocomplete** – typing in the search bar shows product suggestions.
2. **Add to cart** – a product picked from the search results is added to the cart.
3. **Checkout** – from the cart, proceed to checkout and fill in credit card data.

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
