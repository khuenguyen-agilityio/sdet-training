package pages;

import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.WebElementImpl;
import object_behaviors.rules.WebElement;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    private final By input_email = By.id("username"),
            input_password = By.id("password"),
            btn_submit = By.id("login-submit");

    public WebElement inputEmail() {
        return new WebElementImpl($(input_email));
    }

    public WebElement inputPassword() {
        return new WebElementImpl($(input_password));
    }

    public WebElement buttonSubmit() {
        return new WebElementImpl($(btn_submit));
    }
}
