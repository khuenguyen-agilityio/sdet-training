package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class AppointmentConfirmationPage extends UIInteractionSteps {
    private final By
            page_header = By.xpath("//h2[normalize-space()='Appointment Confirmation']"),
            facility = By.id("facility"),
            readmission = By.id("hospital_readmission"),
            program = By.id("program"),
            visit_date = By.id("visit_date"),
            comment = By.id("comment");

    public IWebElement pageHeader() {
        return new WebElement($(page_header));
    }

    public IWebElement facility() {
        return new WebElement($(facility));
    }

    public IWebElement readmission() {
        return new WebElement($(readmission));
    }

    public IWebElement program() {
        return new WebElement($(program));
    }

    public IWebElement visitDate() {
        return new WebElement($(visit_date));
    }

    public IWebElement comment() {
        return new WebElement($(comment));
    }
}
