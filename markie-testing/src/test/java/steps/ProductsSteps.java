package steps;

import actions.ProductsPageActions;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class ProductsSteps {
    @Steps
    private ProductsPageActions actions;

    @Then("Verify user is able to see products page")
    public void verify_user_is_able_to_see_products_page() {
        actions.verifyDefaultFieldsAndFunctions();
    }

}
