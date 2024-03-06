package actions;

import helpers.Storage;
import models.Product;
import org.assertj.core.api.SoftAssertions;
import pages.ProductsPage;

import java.time.Duration;

import static helpers.StorageKey.NEW_PRODUCT;
import static org.assertj.core.api.Assertions.assertThat;


public class ProductsPageActions {
    private ProductsPage productsPage;

    public void verifyDefaultFieldsAndFunctions() {
        productsPage.headerTitle().waitUntilVisible(Duration.ofMinutes(1));
        assertThat(productsPage.headerTitle().getWrappedElement().getText()).isEqualTo("Products");
        assertThat(productsPage.buttonAddProduct().isPresent()).isTrue();
        assertThat(productsPage.inputKeyword().isPresent()).isTrue();
        assertThat(productsPage.buttonSearch().isPresent()).isTrue();
    }

    public void clickButtonAddProduct() {
        productsPage.buttonAddProduct().waitUntilClickable(Duration.ofSeconds(30));
        productsPage.buttonAddProduct().click();
    }

    public void verifySuccessMessage(String msg) {
        productsPage.successToast().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(productsPage.successToast().getText()).isEqualTo(msg);
    }

    public void selectCategory(String category) {
        if (!category.equals(""))
            productsPage.selectCategory().selectByVisibleText(category);
    }

    public void inputSearchKeyword(String keyword) {
        productsPage.inputKeyword().getWrappedElement().sendKeys(keyword);
    }

    public void clickSearchButton() {
        productsPage.buttonSearch().click();
    }

    public void verifyNewProduct() {
        productsPage.loadingSpinner().waitUntilNotVisible(Duration.ofSeconds(30));
        Product product = (Product) Storage.getStorage().getObject(NEW_PRODUCT);
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(productsPage.newProductName(product.getName()).getWrappedElement().getText()).isEqualTo(product.getName());
        assertions.assertThat(productsPage.newProductCategory(product.getName()).getWrappedElement().getText()).isEqualTo(product.getCategory());
        assertions.assertThat(Integer.parseInt(productsPage.newProductQuantity(product.getName()).getWrappedElement().getText())).isEqualTo(product.getQuantity());
        assertions.assertThat(productsPage.newProductPrice(product.getName()).getWrappedElement().getText()).contains(String.valueOf(product.getPrice()));
        assertions.assertAll();
    }

    public void verifyListProductCategoryAndName(String category, String name) {
        productsPage.loadingSpinner().waitUntilNotVisible(Duration.ofSeconds(30));
        SoftAssertions assertions = new SoftAssertions();

        if (!category.isEmpty())
            productsPage.listProductCategory()
                    .forEach(element -> assertions.assertThat(element.getWrappedElement().getText()).isEqualTo(category));
        if (!name.isEmpty())
            productsPage.listProductName()
                    .forEach(element -> assertions.assertThat(element.getWrappedElement().getText()).containsIgnoringCase(name));

        assertions.assertAll();
    }

    public void verifyDisplayNoProductFound() {
        productsPage.loadingSpinner().waitUntilNotVisible(Duration.ofSeconds(30));
        assertThat(productsPage.nothingFound().isPresent()).isTrue();
        assertThat(productsPage.nothingFoundMessage().getWrappedElement().getText()).isEqualTo("No Product Found!!!");
    }

    public void deleteNewProduct() {
        Product product = (Product) Storage.getStorage().getObject(NEW_PRODUCT);
        productsPage.buttonProductActions(product.getName()).click();
        productsPage.buttonDeleteNewProduct(product.getName()).waitUntilVisible(Duration.ofSeconds(30));
        productsPage.buttonDeleteNewProduct(product.getName()).click();
        productsPage.buttonConfirmDeleteProduct().waitUntilVisible(Duration.ofSeconds(30));
        productsPage.buttonConfirmDeleteProduct().click();
        productsPage.successToast().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(productsPage.successToast().getText()).isEqualTo("Delete product successfully");
    }
}
