package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import pages.TrelloPage;

import static contants.SerenityConfigConstants.BASE_URL;

public class TrelloPageActions {
    private TrelloPage trelloPage;

    /**
     * Go to Trello and click on login link
     */
    public void openLoginPage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(BASE_URL);

        // get driver and redirect to Trello page
        Serenity.getDriver().get(url);

        // wait for login button visible and click on it
        trelloPage.buttonLogin("Log in").click();
    }
}
