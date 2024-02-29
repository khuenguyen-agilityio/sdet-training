package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddProductPage extends UIInteractionSteps {
    private final By
            input_name = By.xpath("//input[@data-testid=\"input-product-name\"]"),
            select_category = By.xpath("//select[@data-testid=\"select-product-category\"]"),
            input_quantity = By.xpath("//input[@data-testid=\"input-product-quantity\"]"),
            input_brand = By.xpath("//input[@data-testid=\"input-product-brand\"]"),
            input_price = By.xpath("//input[@data-testid=\"input-product-price\"]");

    public IWebElement inputName() {
        return new WebElement($(input_name));
    }

    public Select selectCategory() {
        return new Select($(select_category));
    }

    public IWebElement inputQuantity() {
        return new WebElement($(input_quantity));
    }

    public IWebElement inputBrand() {
        return new WebElement($(input_brand));
    }

    public IWebElement inputPrice() {
        return new WebElement($(input_price));
    }
}
