package steps;

import actions.AppointmentConfirmationActions;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class AppointmentConfirmationSteps {
    @Steps
    private AppointmentConfirmationActions actions;

    @Then("verify appointment information")
    public void verify_appointment_information() {
        actions.verifyAppointment();
    }

}
