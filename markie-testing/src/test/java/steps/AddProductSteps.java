package steps;

import actions.AddProductPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Product;
import net.serenitybdd.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddProductSteps {
    @Steps
    private AddProductPageActions actions;

    @When("Fill product form with data")
    public void fill_product_form_with_data(List<Map<String, String>> data) {
        List<Product> products = new ArrayList<>();
        data.forEach(row -> products.add(new Product(row)));
        products.forEach(product -> actions.inputProductData(product));
    }

    @Then("Verify display product name error message {string}")
    public void verify_display_product_name_error_message(String msg) {
        actions.verifyProductNameErrorMessage(msg);
    }

    @Then("Verify display product category error message {string}")
    public void verify_display_product_category_error_message(String msg) {
        actions.verifyProductCategoryErrorMessage(msg);
    }

    @Then("Verify display product quantity error message {string}")
    public void verify_display_product_quantity_error_message(String msg) {
        actions.verifyProductQuantityErrorMessage(msg);
    }

    @Then("Verify display product brand error message {string}")
    public void verify_display_product_brand_error_message(String msg) {
        actions.verifyProductBrandErrorMessage(msg);
    }

    @Then("Verify display product price error message {string}")
    public void verify_display_product_price_error_message(String msg) {
        actions.verifyProductPriceErrorMessage(msg);
    }

}
