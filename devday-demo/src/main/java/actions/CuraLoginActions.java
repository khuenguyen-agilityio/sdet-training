package actions;

import net.serenitybdd.core.Serenity;
import pages.CuraLoginPage;

import java.time.Duration;

public class CuraLoginActions {
    private CuraLoginPage curaLoginPage;

    public void openPage() {
        Serenity.getDriver().get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
    }

    public void inputInfoAndLogin(String username, String password) {
        curaLoginPage.pageHeader().waitUntilVisible(Duration.ofMinutes(1));
        curaLoginPage.userName().getWrappedElement().sendKeys(username);
        curaLoginPage.password().getWrappedElement().sendKeys(password);
        curaLoginPage.loginButton().click();
    }
}
