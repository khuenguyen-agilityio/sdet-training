package steps;

import actions.AddProductPageActions;
import io.cucumber.java.en.When;
import models.Product;
import net.serenitybdd.annotations.Steps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddProductSteps {
    @Steps
    private AddProductPageActions actions;

    @When("Fill product form with data")
    public void fill_product_form_with_data(List<Map<String, String>> data) {
        List<Product> products = new ArrayList<>();
        data.forEach(row -> products.add(new Product(row)));
        products.forEach(product -> actions.inputProductData(product));
    }

}
