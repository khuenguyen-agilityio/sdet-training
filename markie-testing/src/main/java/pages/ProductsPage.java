package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends UIInteractionSteps {
    private final By
            header_title = By.xpath("//h1[@data-testid=\"header-title\"]"),
            button_add_product = By.xpath("//button[@data-testid=\"header-action-button\"]"),
            select_category = By.xpath("//select[@data-testid=\"category-select\"]"),
            input_keyword = By.xpath("//input[@data-testid=\"keyword-input\"]"),
            button_search = By.xpath("//button[@data-testid=\"search-button\"]");

    public IWebElement headerTitle() {
        return new WebElement($(header_title));
    }

    public IWebElement buttonAddProduct() {
        return new WebElement($(button_add_product));
    }

    public Select selectCategory() {
        return new Select($(select_category));
    }

    public IWebElement inputKeyword() {
        return new WebElement($(input_keyword));
    }

    public IWebElement buttonSearch() {
        return new WebElement(($(button_search)));
    }
}
