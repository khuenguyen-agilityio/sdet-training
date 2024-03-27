package tasks.start;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import static pages.LoginPage.INPUT_PASSWORD;
import static pages.LoginPage.INPUT_USERNAME;

public class Start {
    public static Performable inputStandardAccount(String username, String password) {
        return Task.where("{0} input the account of " + username,
                Open.browserOn().thePageNamed("pages.home"),
                Enter.theValue(username).into(INPUT_USERNAME),
                Enter.theValue(password).into(INPUT_PASSWORD));
    }
}
