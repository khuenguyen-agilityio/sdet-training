package actions;

import net.serenitybdd.core.Serenity;
import pages.TrelloPage;

import static contants.SerenityConfigConstants.BASE_URL;

public class TrelloPageActions {
    private TrelloPage trelloPage;

    /**
     * Go to Trello and click on login link
     */
    public void openLoginPage() {
        // get driver and redirect to Trello page
        Serenity.getDriver().get(BASE_URL);

        // wait for login button visible and click on it
        trelloPage.loginLink("Log in").getWrappedElement().waitUntilVisible().click();
    }
}
