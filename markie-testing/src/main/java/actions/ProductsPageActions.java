package actions;

import models.Product;
import org.assertj.core.api.SoftAssertions;
import pages.ProductsPage;

import java.time.Duration;

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

    public void verifyNewProduct(Product product) {
        productsPage.loadingSpinner().waitUntilNotVisible(Duration.ofSeconds(30));
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(productsPage.newProductName().getWrappedElement().getText()).isEqualTo(product.getName());
        assertions.assertThat(productsPage.newProductCategory().getWrappedElement().getText()).isEqualTo(product.getCategory());
        assertions.assertThat(Integer.parseInt(productsPage.newProductQuantity().getWrappedElement().getText())).isEqualTo(product.getQuantity());
        assertions.assertThat(productsPage.newProductPrice().getWrappedElement().getText()).contains(String.valueOf(product.getPrice()));
        assertions.assertAll();
    }

    public void verifyListProductCategoryAndName(String category, String name) {
        productsPage.loadingSpinner().waitUntilNotVisible(Duration.ofSeconds(30));
        SoftAssertions assertions = new SoftAssertions();

        if (!category.equals(""))
            productsPage.listProductCategory()
                    .forEach(element -> assertions.assertThat(element.getWrappedElement().getText()).isEqualTo(category));
        if (!name.equals(""))
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
        productsPage.buttonProductActions().click();
        productsPage.buttonDeleteNewProduct().waitUntilVisible(Duration.ofSeconds(30));
        productsPage.buttonDeleteNewProduct().click();
        productsPage.buttonConfirmDeleteProduct().waitUntilVisible(Duration.ofSeconds(30));
        productsPage.buttonConfirmDeleteProduct().click();
        productsPage.successToast().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(productsPage.successToast().getText()).isEqualTo("Delete product successfully");
    }
}
