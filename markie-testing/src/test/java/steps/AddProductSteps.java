package steps;

import actions.AddProductPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Product;
import models.ProductFormError;
import net.serenitybdd.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddProductSteps {
    @Steps
    private AddProductPageActions productPageActions;

    @When("Fill product form with data")
    public void fill_product_form_with_data(List<Map<String, String>> data) {
        List<Product> products = new ArrayList<>();
        data.forEach(row -> products.add(new Product(row)));
        products.forEach(product -> productPageActions.inputProductData(product));
    }

    @Then("Verify display product error message")
    public void verify_display_product_error_message(List<Map<String, String>> data) {
        List<ProductFormError> errors = new ArrayList<>();
        data.forEach(row -> errors.add(new ProductFormError(row)));
        errors.forEach(error -> productPageActions.verifyProductFormErrorMessage(error));
    }

    @When("Click on save product button on product page")
    public void click_on_save_product_button_on_product_page() {
        productPageActions.clickSaveProductButton();
    }
}
