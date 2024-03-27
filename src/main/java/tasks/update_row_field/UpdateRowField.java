package tasks.update_row_field;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.DoubleClick;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import pages.HomePage;

public class UpdateRowField {
    public static Performable called(String row, String column, double value) {
        return Task.where("{0} change the " + column + " value of " + row,
                Scroll.to(HomePage.GRID_ITEM.of(column, row)),
                DoubleClick.on(HomePage.GRID_ITEM.of(column, row)),
                SendKeys.of(String.valueOf(value) + "\n").into(HomePage.INPUT_FIELD.of(row)));
    }
}
