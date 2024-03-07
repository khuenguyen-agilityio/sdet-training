package steps;

import actions.SearchActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class SearchSteps {

    @Steps
    private SearchActions searchActions;

    @Given("user is researching things on the internet")
    public void researching_things() {
        searchActions.navigateToPage();
    }

    @When("user looks up {string}")
    public void searches_for(String term) {
        searchActions.searchFor(term);
    }

    @Then("user should see information about {string}")
    public void should_see_information_about(String term) {
        searchActions.verifyUserSeeSearchResult(term);
    }
}
