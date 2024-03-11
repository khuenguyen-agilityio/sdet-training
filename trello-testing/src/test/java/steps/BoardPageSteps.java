package steps;

import actions.BoardPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class BoardPageSteps {
    @Steps
    private BoardPageActions boardPageActions;

    @Given("User click on the card {string} on the list")
    public void user_click_on_the_card_on_the_list(String title) {
        boardPageActions.clickCardWithTitle(title);
    }

    @When("The user create new label with {string} title")
    public void the_user_create_new_label_with_title(String label) {
        boardPageActions.createNewCardLabel(label);
    }

    @Then("Verify user is able to see the card has label with given title")
    public void verify_user_is_able_to_see_the_card_has_label_with_given_title() {
        boardPageActions.verifyCardLabelTitle();
    }

}
