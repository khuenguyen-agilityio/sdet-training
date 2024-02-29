package actions;

import net.serenitybdd.core.Serenity;
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

    public void verifyEmailErrorMessage(String msg) {
        loginPage.errorMessageEmail().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(loginPage.errorMessageEmail().getText()).isEqualTo(msg);
    }

    public void verifyPasswordErrorMessage(String msg) {
        loginPage.errorMessagePassword().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(loginPage.errorMessagePassword().getText()).isEqualTo(msg);
    }

    public void verifyErrorToastMessage(String msg) {
        loginPage.errorToast().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(loginPage.errorToast().getText()).isEqualTo(msg);
    }
}
