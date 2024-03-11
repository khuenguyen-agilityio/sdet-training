package steps;

import actions.BoardPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class BoardPageSteps {
    @Steps
    private BoardPageActions boardPageActions;

    @Given("The user click on the card {string} on the list")
    public void the_user_click_on_the_card_on_the_list(String title) {
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

    @Given("The user click on label button on the right sidebar")
    public void the_user_click_on_label_button_on_the_right_sidebar() {
        boardPageActions.clickLabelButton();
    }

    @Given("The user click on button with title {string}")
    public void the_user_click_on_button_with_title(String title) {
        boardPageActions.clickButtonLabelAction(title);
    }

    @When("The user click on remove color button of a label")
    public void the_user_click_on_remove_color_button_of_a_label() {
        boardPageActions.clickButtonRemoveColor();
    }

    @Then("Verify the user is not able to click {string} button")
    public void verify_the_user_is_not_able_to_click_button(String title) {
        boardPageActions.verifyButtonLabelsActionIsDisabled(title);
    }

}
