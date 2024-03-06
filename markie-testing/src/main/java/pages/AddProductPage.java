package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class AddProductPage extends PageObject {
    private final By
            input_name = By.xpath("//input[@data-testid='input-product-name']"),
            select_category = By.xpath("//select[@data-testid='select-product-category']"),
            input_quantity = By.xpath("//input[@data-testid='input-product-quantity']"),
            input_brand = By.xpath("//input[@data-testid='input-product-brand']"),
            input_price = By.xpath("//input[@data-testid='input-product-price']"),
            button_header_action = By.xpath("//button[@data-testid='header-action-button']"),
            error_msg_name = By.xpath("//div[@data-testid='error-msg-product-name']"),
            error_msg_category = By.xpath("//div[@data-testid='error-msg-category']"),
            error_msg_quantity = By.xpath("//div[@data-testid='error-msg-quantity']"),
            error_msg_brand = By.xpath("//div[@data-testid='error-msg-brand']"),
            error_msg_price = By.xpath("//div[@data-testid='error-msg-price']");

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

    public IWebElement buttonSaveProduct() {
        return new WebElement($(button_header_action));
    }

    public IWebElement errorMessageName() {
        return new WebElement($(error_msg_name));
    }

    public IWebElement errorMessageCategory() {
        return new WebElement($(error_msg_category));
    }

    public IWebElement errorMessageQuantity() {
        return new WebElement($(error_msg_quantity));
    }

    public IWebElement errorMessageBrand() {
        return new WebElement($(error_msg_brand));
    }

    public IWebElement errorMessagePrice() {
        return new WebElement($(error_msg_price));
    }
}
