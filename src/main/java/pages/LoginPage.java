package pages;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target INPUT_USERNAME = Target.the("Input username field").locatedBy("//input[@id='user-name']");
    public static final Target INPUT_PASSWORD = Target.the("Input password field").locatedBy("//input[@id='password']");
    public static final Target BUTTON_SUBMIT = Target.the("Button submit login").locatedBy("//input[@id='login-button']");
}
