package actions;

import pages.AppointmentPage;

import java.time.Duration;

public class AppoimentActions {
    private AppointmentPage page;

    public void verifyUserIsAbleToSeeTheAppointmentPage() {
        page.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
    }
}
