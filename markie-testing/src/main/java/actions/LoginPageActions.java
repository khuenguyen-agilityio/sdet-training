package actions;

import net.serenitybdd.core.Serenity;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageActions {
    private LoginPage loginPage;

    public void openLoginPage() {
        Serenity.getDriver().get("https://markie-store.vercel.app/login");
    }

    public void inputEmailAndPassword(String email, String password) {
        loginPage.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
        loginPage.inputEmail().getWrappedElement().sendKeys(email);
        loginPage.inputPassword().getWrappedElement().sendKeys(password);
        loginPage.buttonLogin().click();
    }
}
