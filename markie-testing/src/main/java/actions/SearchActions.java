package actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.di.SerenityInfrastructure;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import contants.SerenityConfigConstants;
import org.assertj.core.api.SoftAssertions;
import pages.SearchPage;


public class SearchActions {

    private SearchPage searchPage;

    public void navigateToPage() {
        EnvironmentVariables environmentVariables = SerenityInfrastructure.getEnvironmentVariables();
        String url = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(SerenityConfigConstants.BASEURL);
        Serenity.getDriver().get(url);
    }

    public void searchFor(String term) {
        searchPage.searchInput().typeAndEnter(term);
    }

    public void verifyUserSeeSearchResult(String term) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(searchPage.searchResult().getWrappedElement().isDisplayed()).isTrue();
        softAssertions.assertThat(searchPage.searchFormInput().getWrappedElement().getValue()).isEqualTo(term);
        softAssertions.assertAll();
    }
}
