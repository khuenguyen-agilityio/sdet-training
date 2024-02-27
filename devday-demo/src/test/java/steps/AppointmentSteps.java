package steps;

import actions.AppointmentActions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class AppointmentSteps {
    @Steps
    private AppointmentActions actions;

    @Then("User can see Appointment Page")
    public void user_can_see_appointment_page() {
        actions.verifyUserIsAbleToSeeTheAppointmentPage();
    }

    @When("Select {string} in Facility")
    public void select_in_facility(String option) {
        actions.selectFacilityOption(option);
    }

    @When("Apply for hospital readmission")
    public void apply_for_hospital_readmission() {
        actions.checkReadmission();
    }

    @When("Pick visit date {string}")
    public void pick_visit_date(String date) {
        actions.pickVisitDate(date);
    }

    @When("Write comment {string}")
    public void write_comment(String comment) {
        actions.writeComment(comment);
    }

    @When("Click submit appointment button")
    public void click_submit_appointment_button() {
        actions.submitAppoiment();
    }


}
