package actions;

import net.serenitybdd.core.Serenity;
import org.assertj.core.api.SoftAssertions;
import pages.LoginPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

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

    public void verifyLoginErrorMessage(String fieldEmail, String fieldPassword) {
        SoftAssertions assertions = new SoftAssertions();

        if (!fieldEmail.equals("")) {
            loginPage.errorMessageEmail().waitUntilVisible(Duration.ofSeconds(30));
            assertions.assertThat(loginPage.errorMessageEmail().getText()).isEqualTo(fieldEmail);
        }

        if (!fieldPassword.equals("")) {
            loginPage.errorMessagePassword().waitUntilVisible(Duration.ofSeconds(30));
            assertions.assertThat(loginPage.errorMessagePassword().getText()).isEqualTo(fieldPassword);
        }

        assertions.assertAll();
    }

    public void verifyErrorToastMessage(String msg) {
        loginPage.errorToast().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(loginPage.errorToast().getText()).isEqualTo(msg);
    }
}
