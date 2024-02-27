package steps;

import actions.AppoimentActions;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;

public class AppointmentSteps {
    @Steps
    private AppoimentActions actions;

    @Then("User can see Appointment Page")
    public void user_can_see_appointment_page() {
        actions.verifyUserIsAbleToSeeTheAppointmentPage();
    }
}
