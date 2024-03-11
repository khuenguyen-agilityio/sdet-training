package actions;

import net.serenitybdd.core.Serenity;
import pages.LoginPage;

public class LoginPageActions {
    private LoginPage loginPage;

    public void openLoginPage() {
        Serenity.getDriver().get("https://id.atlassian.com/login?application=trello");
    }

    /**
     * Login with given email and password
     *
     * @param email
     * @param password
     */
    public void loginWithEmailAndPassword(String email, String password) {
        // wait for input email visible and click on continue button
        loginPage.inputEmail().getWrappedElement().waitUntilVisible().sendKeys(email);
        loginPage.buttonSubmit().click();

        // wait for input password visible and click on submit button
        loginPage.inputPassword().getWrappedElement().waitUntilVisible().sendKeys(password);
        loginPage.buttonSubmit().click();
    }
}
