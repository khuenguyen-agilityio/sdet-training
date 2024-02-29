package actions;

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
}
