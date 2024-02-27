package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class CuraLoginPage extends UIInteractionSteps {
    private final By
            page_header = By.xpath("//h1[normalize-space()='CURA Healthcare Service']"),
            user_name = By.id("txt-username"),
            user_password = By.id("txt-password"),
            login_button = By.id("btn-login");

    public IWebElement pageHeader() {
        return new WebElement($(page_header));
    }

    public IWebElement userName() {
        return new WebElement($(user_name));
    }

    public IWebElement password() {
        return new WebElement($(user_password));
    }

    public IWebElement loginButton() {
        return new WebElement($(login_button));
    }
}
