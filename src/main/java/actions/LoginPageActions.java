package actions;

import pages.LoginPage;

public class LoginPageActions {
    private LoginPage loginPage;

    /**
     * Login with given email and password
     *
     * @param email    email of account
     * @param password password of account
     */
    public void loginWithEmailAndPassword(String email, String password) {
        // wait for input email clickable and click on continue button
        loginPage.inputEmail().type(email);
        loginPage.buttonSubmit().click();

        // wait for input password clickable and click on submit button
        loginPage.inputPassword().type(password);
        loginPage.buttonSubmit().click();
    }
}
