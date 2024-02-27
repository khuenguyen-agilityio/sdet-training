package actions;

import pages.AppointmentPage;

import java.time.Duration;

public class AppointmentActions {
    private AppointmentPage page;

    public void verifyUserIsAbleToSeeTheAppointmentPage() {
        page.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
    }

    public void selectFacilityOption(String option) {
        page.facilitySelect().selectByVisibleText(option);
    }

    public void checkReadmission() {
        page.hospitalReadmission().click();
    }

    public void pickVisitDate(String date) {
        page.visitDate().getWrappedElement().clear();
        page.visitDate().getWrappedElement().sendKeys(date);
    }

    public void writeComment(String comment) {
        page.commentTextArea().getWrappedElement().sendKeys(comment);
    }

    public void submitAppoiment() {
        page.buttonBookAppointment().click();
    }
}
