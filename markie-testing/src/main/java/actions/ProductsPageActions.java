package actions;

import pages.ProductsPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;


public class ProductsPageActions {
    private ProductsPage productsPage;

    public void verifyDefaultFieldsAndFunctions() {
        productsPage.headerTitle().waitUntilVisible(Duration.ofMinutes(1));
        assertThat(productsPage.headerTitle().getWrappedElement().getText()).isEqualTo("Products");
        assertThat(productsPage.buttonHeaderAction().isPresent()).isTrue();
        assertThat(productsPage.inputKeyword().isPresent()).isTrue();
        assertThat(productsPage.buttonSearch().isPresent()).isTrue();
    }

    public void clickButtonHeaderAction() {
        productsPage.buttonHeaderAction().click();
    }

    public void verifySuccessMessage(String msg) {
        productsPage.successToast().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(productsPage.successToast().getText()).isEqualTo(msg);
    }

    public void verifyFirstProductName(String msg) {
        productsPage.firstProductName().waitUntilVisible(Duration.ofSeconds(30));
        assertThat(productsPage.firstProductName().getText()).isEqualTo(msg);
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

    public void verifyListProductCategory(String category) {
        productsPage.loadingSpinner().waitUntilNotVisible(Duration.ofSeconds(30));
        if (!category.equals(""))
            productsPage.listProductCategory()
                    .forEach(element -> assertThat(element.getWrappedElement().getText()).isEqualTo(category));
    }

    public void verifyListProductName(String name) {
        productsPage.loadingSpinner().waitUntilNotVisible(Duration.ofSeconds(30));
        if (!name.equals(""))
            productsPage.listProductName()
                    .forEach(element -> assertThat(element.getWrappedElement().getText()).containsIgnoringCase(name));
    }
}
