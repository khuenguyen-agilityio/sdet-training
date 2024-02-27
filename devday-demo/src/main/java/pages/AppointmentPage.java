package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage extends UIInteractionSteps {
    private final By
            page_header = By.xpath("//h2[normalize-space()='Make Appointment']"),
            facility_select = By.id("combo_facility"),
            hospital_readmission = By.id("chk_hospotal_readmission"),
            visit_date = By.id("txt_visit_date"),
            comment_text_area = By.id("txt_comment"),
            button_book_appointment = By.id("btn-book-appointment");

    public IWebElement pageHeader() {
        return new WebElement($(page_header));
    }

    public Select facilitySelect() {
        return new Select($(facility_select));
    }

    public IWebElement hospitalReadmission() {
        return new WebElement($(hospital_readmission));
    }

    public IWebElement visitDate() {
        return new WebElement($(visit_date));
    }

    public IWebElement commentTextArea() {
        return new WebElement($(comment_text_area));
    }

    public IWebElement buttonBookAppointment() {
        return new WebElement($(button_book_appointment));
    }
}
