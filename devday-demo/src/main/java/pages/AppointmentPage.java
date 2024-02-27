package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class AppointmentPage extends UIInteractionSteps {
    private final By page_header = By.xpath("//h2[normalize-space()='Make Appointment']");

    public IWebElement pageHeader() {
        return new WebElement($(page_header));
    }
}
