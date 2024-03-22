package pages;

import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.ButtonImpl;
import object_behaviors.implementation.TextInputImpl;
import object_behaviors.rules.Button;
import object_behaviors.rules.TextInput;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private final By input_email = By.id("username"),
            input_password = By.id("password"),
            btn_submit = By.id("login-submit");

    public TextInput inputEmail() {
        return new TextInputImpl($(input_email));
    }

    public TextInput inputPassword() {
        return new TextInputImpl($(input_password));
    }

    public Button buttonSubmit() {
        return new ButtonImpl($(btn_submit));
    }
}
