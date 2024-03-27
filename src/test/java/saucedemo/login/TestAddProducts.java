package saucedemo.login;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import tasks.add_product.AddProductsToCart;
import tasks.login.Login;
import tasks.start.Start;

import java.util.ArrayList;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

@ExtendWith(SerenityJUnit5Extension.class)
public class TestAddProducts {
    private Actor khue = Actor.named("Khue");

    @Managed
    private WebDriver hisBrowser;

    @BeforeEach
    public void khueCanBrowseTheWeb() {
        khue.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    void shouldAddProductsToCart() {
        List<String> products = new ArrayList<>();
        products.add("Sauce Labs Backpack");
        products.add("Sauce Labs Bike Light");

        givenThat(khue).wasAbleTo(
                Start.inputStandardAccount("standard_user", "secret_sauce"),
                Login.clickSubmitButton()
        );

        when(khue).attemptsTo(AddProductsToCart.called(products));
    }
}
