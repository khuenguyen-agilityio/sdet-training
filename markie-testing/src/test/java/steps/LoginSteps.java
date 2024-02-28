package steps;

import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginSteps {
    @Steps
    private LoginPageActions actions;

    @Given("Login page is opened")
    public void login_page_is_opened() {
        actions.openLoginPage();
    }
    @When("Input information with specify email {string} and password {string}")
    public void input_information_with_specify_email_and_password(String email, String password) {
        actions.inputEmailAndPassword(email, password);
    }

}
