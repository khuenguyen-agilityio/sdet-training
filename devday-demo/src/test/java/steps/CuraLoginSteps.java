package steps;

import actions.CuraLoginActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CuraLoginSteps {
    @Steps
    private CuraLoginActions actions;

    @Given("Cura Login Page is opened")
    public void cura_login_page_is_opened() {
        actions.openPage();
    }

    @When("Type {string} and {string} to login")
    public void type_and_to_login(String username, String password) {
        actions.inputInfoAndLogin(username, password);
    }
}
