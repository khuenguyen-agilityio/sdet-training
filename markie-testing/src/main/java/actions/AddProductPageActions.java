package actions;

import helpers.Storage;
import models.Product;
import models.ProductFormError;
import org.assertj.core.api.SoftAssertions;
import pages.AddProductPage;

import java.time.Duration;

import static utils.StorageKey.NEW_PRODUCT;

public class AddProductPageActions {
    private AddProductPage addProductPage;

    public void inputProductData(Product product) {
        addProductPage.inputName().waitUntilVisible(Duration.ofSeconds(30));
        addProductPage.inputName().getWrappedElement().sendKeys(product.getName());
        addProductPage.selectCategory().selectByVisibleText(product.getCategory());
        addProductPage.inputQuantity().getWrappedElement().sendKeys(String.valueOf(product.getQuantity()));
        addProductPage.inputBrand().getWrappedElement().sendKeys(product.getBrand());
        addProductPage.inputPrice().getWrappedElement().sendKeys(String.valueOf(product.getPrice()));
        Storage.getStorage().saveObjectValue(NEW_PRODUCT, product);
    }

    public void clickSaveProductButton() {
        addProductPage.buttonSaveProduct().waitUntilClickable(Duration.ofSeconds(30));
        addProductPage.buttonSaveProduct().click();
    }

    public void verifyProductFormErrorMessage(ProductFormError error) {
        SoftAssertions assertions = new SoftAssertions();
        if (!error.getFieldName().isEmpty())
            assertions.assertThat(addProductPage.errorMessageName().getWrappedElement().getText()).isEqualTo(error.getFieldName());

        if (!error.getFieldCategory().isEmpty())
            assertions.assertThat(addProductPage.errorMessageCategory().getWrappedElement().getText()).isEqualTo(error.getFieldCategory());

        if (!error.getFieldQuantity().isEmpty())
            assertions.assertThat(addProductPage.errorMessageQuantity().getWrappedElement().getText()).isEqualTo(error.getFieldQuantity());

        if (!error.getFieldBrand().isEmpty())
            assertions.assertThat(addProductPage.errorMessageBrand().getWrappedElement().getText()).isEqualTo(error.getFieldBrand());

        if (!error.getFieldPrice().isEmpty())
            assertions.assertThat(addProductPage.errorMessagePrice().getWrappedElement().getText()).isEqualTo(error.getFieldPrice());
        assertions.assertAll();
    }
}
