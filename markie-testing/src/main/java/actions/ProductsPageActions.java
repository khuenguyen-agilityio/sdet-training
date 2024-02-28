package actions;

import pages.ProductsPage;

import java.time.Duration;
import static org.assertj.core.api.Assertions.assertThat;


public class ProductsPageActions {
    private ProductsPage productsPage;

    public void verifyDefaultFieldsAndFunctions() {
        productsPage.buttonAddProduct().waitUntilVisible(Duration.ofMinutes(1));
        assertThat(productsPage.buttonAddProduct().isPresent()).isTrue();
    }
}
