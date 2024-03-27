package tasks.login;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static pages.LoginPage.BUTTON_SUBMIT;

public class Login {
    public static Task clickSubmitButton() {
        return Task.where("{0} hit the submit button",
                Click.on(BUTTON_SUBMIT));
    }
}