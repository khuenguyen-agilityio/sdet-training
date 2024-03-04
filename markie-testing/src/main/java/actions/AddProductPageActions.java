package actions;

import models.Product;
import pages.AddProductPage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class AddProductPageActions {
    private AddProductPage addProductPage;

    public void inputProductData(Product product) {
        addProductPage.inputName().waitUntilVisible(Duration.ofSeconds(30));
        addProductPage.inputName().getWrappedElement().sendKeys(product.getName());
        addProductPage.selectCategory().selectByVisibleText(product.getCategory());
        addProductPage.inputQuantity().getWrappedElement().sendKeys(String.valueOf(product.getQuantity()));
        addProductPage.inputBrand().getWrappedElement().sendKeys(product.getBrand());
        addProductPage.inputPrice().getWrappedElement().sendKeys(String.valueOf(product.getPrice()));
    }

    public void verifyProductNameErrorMessage(String msg) {
        assertThat(addProductPage.errorMessageName().getWrappedElement().getText()).isEqualTo(msg);
    }

    public void verifyProductCategoryErrorMessage(String msg) {
        assertThat(addProductPage.errorMessageCategory().getWrappedElement().getText()).isEqualTo(msg);
    }

    public void verifyProductQuantityErrorMessage(String msg) {
        assertThat(addProductPage.errorMessageQuantity().getWrappedElement().getText()).isEqualTo(msg);
    }

    public void verifyProductBrandErrorMessage(String msg) {
        assertThat(addProductPage.errorMessageBrand().getWrappedElement().getText()).isEqualTo(msg);
    }

    public void verifyProductPriceErrorMessage(String msg) {
        assertThat(addProductPage.errorMessagePrice().getWrappedElement().getText()).isEqualTo(msg);
    }
}
