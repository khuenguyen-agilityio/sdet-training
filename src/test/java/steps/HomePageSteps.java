package steps;

import actions.HomePageActions;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

public class HomePageSteps {
    @Steps
    private HomePageActions homePageActions;

    @Given("The user choose the board with name {string}")
    public void the_user_choose_the_board_with_name(String name) {
        homePageActions.clickBoard(name);
    }
}
