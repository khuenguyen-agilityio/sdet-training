package steps;

import actions.LoginPageActions;
import io.cucumber.java.en.Given;
import net.serenitybdd.annotations.Steps;

public class LoginPageSteps {
    @Steps
    private LoginPageActions loginPageActions;

    @Given("The user input information with specify email {string} and password {string}")
    public void the_user_input_information_with_specify_email_and_password(String email, String password) {
        loginPageActions.loginWithEmailAndPassword(email, password);
    }
}
