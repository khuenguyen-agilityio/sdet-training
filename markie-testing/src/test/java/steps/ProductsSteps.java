package steps;

import actions.ProductsPageActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class ProductsSteps {
    @Steps
    private ProductsPageActions actions;

    @Then("Verify user is able to see products page")
    public void verify_user_is_able_to_see_products_page() {
        actions.verifyDefaultFieldsAndFunctions();
    }

    @When("Click on header action button")
    public void click_on_header_action_button() {
        actions.clickButtonHeaderAction();
    }

    @Then("Verify display success toast message {string}")
    public void verify_display_success_toast_message(String msg) {
        actions.verifySuccessMessage(msg);
    }

    @Then("First product name of the list is {string}")
    public void first_product_name_of_the_list_is(String msg) {
        actions.verifyFirstProductName(msg);
    }

}
