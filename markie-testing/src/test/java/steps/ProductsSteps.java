package steps;

import actions.ProductsPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Product;
import net.serenitybdd.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProductsSteps {
    @Steps
    private ProductsPageActions productsPageActions;

    @Then("Verify user is able to see products page")
    public void verify_user_is_able_to_see_products_page() {
        productsPageActions.verifyDefaultFieldsAndFunctions();
    }

    @When("The user click on button add product in the top right corner")
    public void click_on_button_add_product_in_the_top_right_corner() {
        productsPageActions.clickButtonAddProduct();
    }

    @Then("Verify display success toast message {string}")
    public void verify_display_success_toast_message(String msg) {
        productsPageActions.verifySuccessMessage(msg);
    }

    @Then("Verify new product has been created")
    public void verify_new_product_has_been_created(List<Map<String, String>> data) {
        List<Product> products = new ArrayList<>();
        data.forEach(row -> products.add(new Product(row)));
        products.forEach(product -> productsPageActions.verifyNewProduct(product));
    }

    @When("The user select category {string} in Search with Category form control")
    public void select_category_in_search_with_category_form_control(String category) {
        productsPageActions.selectCategory(category);
    }

    @When("The user input search keyword {string} in Search with form control")
    public void input_search_keyword_in_search_with_form_control(String keyword) {
        productsPageActions.inputSearchKeyword(keyword);
    }

    @When("The user click on Search for product button on product page")
    public void click_on_search_button() {
        productsPageActions.clickSearchButton();
    }

    @Then("Verify search products have {string} category and name contains keyword {string}")
    public void verify_search_products_have_category_and_name_contains_keyword(String category, String keyword) {
        productsPageActions.verifyListProductCategoryAndName(category, keyword);
    }

    @Then("Verify user can see no product found")
    public void verify_display_no_product_found() {
        productsPageActions.verifyDisplayNoProductFound();
    }

}
