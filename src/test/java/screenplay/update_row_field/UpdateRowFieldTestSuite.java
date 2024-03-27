package screenplay.update_row_field;

import net.serenitybdd.annotations.Managed;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import tasks.start.Start;
import tasks.update_row_field.UpdateRowField;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.when;

@ExtendWith(SerenityJUnit5Extension.class)
public class UpdateRowFieldTestSuite {
    private Actor khue = Actor.named("Khue");

    @Managed
    private WebDriver hisBrowser;

    @BeforeEach
    public void khueCanBrowseTheWeb() {
        khue.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void shouldChangeTheFieldValue() {
        givenThat(khue).wasAbleTo(Start.withAnDataGrid());

        when(khue).attemptsTo(UpdateRowField.called("Andrew Hayden", "jan", 20000));
    }
}
