package actions;

import models.Product;
import pages.AddProductPage;

public class AddProductPageActions {
    private AddProductPage addProductPage;

    public void inputProductData(Product product) {
        addProductPage.inputName().getWrappedElement().sendKeys(product.getName());
        addProductPage.selectCategory().selectByVisibleText(product.getCategory());
        addProductPage.inputQuantity().getWrappedElement().sendKeys(String.valueOf(product.getQuantity()));
        addProductPage.inputBrand().getWrappedElement().sendKeys(product.getBrand());
        addProductPage.inputPrice().getWrappedElement().sendKeys(String.valueOf(product.getPrice()));
    }
}
