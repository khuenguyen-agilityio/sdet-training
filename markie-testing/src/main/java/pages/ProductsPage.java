package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

public class ProductsPage extends UIInteractionSteps {
    private final By
            button_add_product = By.xpath("//button[@data-testid=\"header-action-button\"]");

    public IWebElement buttonAddProduct() {
        return new WebElement($(button_add_product));
    }
}
