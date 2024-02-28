package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class LoginPage extends UIInteractionSteps {
    private final By
            page_header = By.xpath("//h1[normalize-space()='Welcome to Markie']"),
            input_email = By.xpath("//input[@data-testid=\"email-input\"]"),
            input_password = By.xpath("//input[@data-testid=\"password-input\"]"),
            button_login = By.xpath("//button[@data-testid=\"submit-button\"]");

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
}
