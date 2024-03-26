package pages;

import net.serenitybdd.screenplay.targets.Target;

public class ProductPage {
    public static final Target PAGE_TITLE = Target.the("The page title").locatedBy("//span[@class='title']");
}
