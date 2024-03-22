package steps;

import actions.TrelloPageActions;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

public class TrelloPageSteps {
    @Steps
    private TrelloPageActions trelloPageActions;

    @Given("The user is on Trello login page")
    public void the_user_is_on_trello_login_page() {
        trelloPageActions.openLoginPage();
    }
}
