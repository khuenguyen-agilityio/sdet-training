package pages;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {
    public static final Target GRID_ITEM = Target.the("{0} value of {1}").locatedBy("//div[@row-business-key='{1}']//div[@col-id='{0}']");
    public static final Target INPUT_FIELD = Target.the("The input editor of {0}").locatedBy("//div[@row-business-key='{0}']//input[contains(@class, 'ag-number-field-input')]");
}
