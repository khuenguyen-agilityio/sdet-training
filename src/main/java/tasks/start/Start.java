package tasks.start;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class Start {
    public static Performable withAnDataGrid() {
        return Task.where("{0} starts with an data grid",
                Open.browserOn().thePageNamed("pages.home"));
    }
}
