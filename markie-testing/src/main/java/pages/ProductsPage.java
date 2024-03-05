package pages;

import helpers.IWebElement;
import helpers.WebElement;
import net.serenitybdd.core.pages.ListOfWebElementFacades;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends UIInteractionSteps {
    private final By
            header_title = By.xpath("//h1[@data-testid='header-title']"),
            button_header_action = By.xpath("//button[@data-testid='header-action-button']"),
            select_category = By.xpath("//select[@data-testid='category-select']"),
            input_keyword = By.xpath("//input[@data-testid='keyword-input']"),
            button_search = By.xpath("//button[@data-testid='search-button']"),
            success_toast = By.xpath("//div[@data-status='success']"),
            loading_spinner = By.xpath("//div[@data-testid='loading-spinner']"),
            new_product_name = By.xpath("//p[@data-testid='product-name' and text()='New Product Test 101']"),
            new_product_category = By.xpath("//p[@data-testid='product-name' and text()='New Product Test 101']/parent::li/p[@data-testid='product-category']"),
            new_product_price = By.xpath("//p[@data-testid='product-name' and text()='New Product Test 101']/parent::li/p[@data-testid='product-price']"),
            new_product_quantity = By.xpath("//p[@data-testid='product-name' and text()='New Product Test 101']/parent::li/p[@data-testid='product-quantity']"),
            new_product_menu_btn = By.xpath("//p[@data-testid='product-name' and text()='New Product Test 101']/parent::li/descendant::button[@data-testid='menu-button']"),
            new_product_delete_btn = By.xpath("//p[@data-testid='product-name' and text()='New Product Test 101']/parent::li/descendant::button[@data-testid='delete-button']"),
            confirm_delete_btn = By.xpath("//button[@type='button' and text()='Confirm']"),
            list_product_name = By.xpath("//ul[@data-testid='product-list']/li/p[@data-testid='product-name']"),
            list_product_category = By.xpath("//ul[@data-testid='product-list']/li/p[@data-testid='product-category']"),
            nothing_found = By.xpath("//div[@data-testid='nothing-found']"),
            nothing_found_message = By.xpath("//div[@data-testid='nothing-found']/p");

    public IWebElement headerTitle() {
        return new WebElement($(header_title));
    }

    public IWebElement buttonAddProduct() {
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

    public IWebElement loadingSpinner() {
        return new WebElement($(loading_spinner));
    }

    public IWebElement newProductName() {
        return new WebElement($(new_product_name));
    }

    public IWebElement newProductCategory() {
        return new WebElement($(new_product_category));
    }

    public IWebElement newProductQuantity() {
        return new WebElement($(new_product_quantity));
    }

    public IWebElement newProductPrice() {
        return new WebElement($(new_product_price));
    }

    public IWebElement buttonProductActions() {
        return new WebElement($(new_product_menu_btn));
    }

    public IWebElement buttonDeleteNewProduct() {
        return new WebElement($(new_product_delete_btn));
    }

    public IWebElement buttonConfirmDeleteProduct() {
        return new WebElement($(confirm_delete_btn));
    }


    public ListOfWebElementFacades listProductName() {
        return ($$(list_product_name));
    }

    public ListOfWebElementFacades listProductCategory() {
        return ($$(list_product_category));
    }

    public IWebElement nothingFound() {
        return new WebElement($(nothing_found));
    }

    public IWebElement nothingFoundMessage() {
        return new WebElement($(nothing_found_message));
    }
}
