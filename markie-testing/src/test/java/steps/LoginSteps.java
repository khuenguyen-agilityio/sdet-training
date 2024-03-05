package steps;

import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class LoginSteps {
    @Steps
    private LoginPageActions loginPageActions;

    @Given("Login page is opened")
    public void login_page_is_opened() {
        loginPageActions.openLoginPage();
    }

    @When("Input information with specify email {string} and password {string}")
    public void input_information_with_specify_email_and_password(String email, String password) {
        loginPageActions.inputEmailAndPassword(email, password);
    }

    @Then("Verify user is able to see email error message {string} and password error message {string}")
    public void verify_user_is_able_to_see_email_error_message_and_password_error_message(String fieldEmail, String fieldPassword) {
        loginPageActions.verifyLoginErrorMessage(fieldEmail, fieldPassword);
    }

    @Then("Verify user is able to see toast message {string}")
    public void verify_user_is_able_to_see_toast_message(String msg) {
        loginPageActions.verifyErrorToastMessage(msg);
    }
}
