package saucedemo.login;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import questions.ProductPageHeading;
import tasks.LoginTasks;
import tasks.Start;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestLogin {
    private Actor khue = Actor.named("Khue");

    @Managed
    private WebDriver hisBrowser;

    @BeforeEach
    public void khueCanBrowseTheWeb() {
        khue.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    void shouldLoginToTheApp() {
        givenThat(khue).wasAbleTo(Start.inputStandardAccount("standard_user", "secret_sauce"));

        when(khue).attemptsTo(LoginTasks.clickSubmitButton());

        then(khue).should(seeThat(ProductPageHeading.textHeading(), equalTo("Products")));
    }
}
