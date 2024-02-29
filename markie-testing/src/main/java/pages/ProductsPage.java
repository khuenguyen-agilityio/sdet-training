package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends UIInteractionSteps {
    private final By
            header_title = By.xpath("//h1[@data-testid=\"header-title\"]"),
            button_header_action = By.xpath("//button[@data-testid=\"header-action-button\"]"),
            select_category = By.xpath("//select[@data-testid=\"category-select\"]"),
            input_keyword = By.xpath("//input[@data-testid=\"keyword-input\"]"),
            button_search = By.xpath("//button[@data-testid=\"search-button\"]"),
            success_toast = By.xpath("//div[@data-status=\"success\"]"),
            first_product_name = By.xpath("//ul[@data-testid=\"product-list\"]/*[1]/p[@data-testid=\"product-name\"]");

    public IWebElement headerTitle() {
        return new WebElement($(header_title));
    }

    public IWebElement buttonHeaderAction() {
        return new WebElement($(button_header_action));
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

    public IWebElement successToast() {
        return new WebElement($(success_toast));
    }

    public IWebElement firstProductName() {
        return new WebElement($(first_product_name));
    }
}
