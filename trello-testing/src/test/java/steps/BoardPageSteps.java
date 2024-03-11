package steps;

import actions.BoardPageActions;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

public class BoardPageSteps {
    @Steps
    private BoardPageActions boardPageActions;

    @Given("User click on the card {string} on the list")
    public void user_click_on_the_card_on_the_list(String title) {
        boardPageActions.clickCardWithTitle(title);
    }

}
