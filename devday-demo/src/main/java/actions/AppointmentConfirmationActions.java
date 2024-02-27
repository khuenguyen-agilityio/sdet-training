package actions;

import pages.AppointmentConfirmationPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AppointmentConfirmationActions {
    private AppointmentConfirmationPage page;

    public void verifyAppointment() {
        page.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
        assertThat(page.facility().getText()).isEqualTo("Seoul CURA Healthcare Center");
        assertThat(page.readmission().getText()).isEqualTo("Yes");
        assertThat(page.program().getText()).isEqualTo("Medicare");
        assertThat(page.visitDate().getText()).isEqualTo("20/08/2024");
        assertThat(page.comment().getText()).isEqualTo("This is a comment");
    }
}
