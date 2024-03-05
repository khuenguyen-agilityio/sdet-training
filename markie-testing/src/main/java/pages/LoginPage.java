package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class LoginPage extends UIInteractionSteps {
    private final By
            page_header = By.xpath("//h1[normalize-space()='Welcome to Markie']"),
            input_email = By.xpath("//input[@data-testid='email-input']"),
            input_password = By.xpath("//input[@data-testid='password-input']"),
            button_login = By.xpath("//button[@data-testid='submit-button']"),
            error_msg_email = By.xpath("//div[@data-testid='error-msg-email']"),
            error_msg_password = By.xpath("//div[@data-testid='error-msg-password']"),
            error_toast = By.xpath("//div[@data-status='error']");

    public IWebElement pageHeader() {
        return new WebElement($(page_header));
    }

    public IWebElement inputEmail() {
        return new WebElement($(input_email));
    }

    public IWebElement inputPassword() {
        return new WebElement($(input_password));
    }

    public IWebElement buttonLogin() {
        return new WebElement($(button_login));
    }

    public IWebElement errorMessageEmail() {
        return new WebElement($(error_msg_email));
    }

    public IWebElement errorMessagePassword() {
        return new WebElement($(error_msg_password));
    }

    public IWebElement errorToast() {
        return new WebElement($(error_toast));
    }
}
