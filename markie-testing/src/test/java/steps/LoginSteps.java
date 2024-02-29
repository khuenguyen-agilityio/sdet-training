package steps;

import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @Then("Verify user is able to see error message {string} on the page")
    public void verify_user_is_able_to_see_error_message_on_the_page(String msg) {
        actions.verifyEmailErrorMessage(msg);
        actions.verifyPasswordErrorMessage(msg);
    }

    @Then("Verify user is able to see toast message {string}")
    public void verify_user_is_able_to_see_toast_message(String msg) {
        actions.verifyErrorToastMessage(msg);
    }
}
