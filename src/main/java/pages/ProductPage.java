package pages;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {
    public static final Target PAGE_TITLE = Target.the("The page title").locatedBy("//span[@class='title']");
    public static final Target ADD_TO_CARD = Target.the("Button add {0} to cart").locatedBy("//div[contains(@class, 'inventory_item') and .//div[text()='{0}']]//button");
}
