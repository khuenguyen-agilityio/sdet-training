package tasks.add_product;

import com.google.common.collect.ImmutableList;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Collection;
import java.util.List;

public class AddProductsToCart implements Task {
    private List<String> products;

    public AddProductsToCart() {
    }

    public AddProductsToCart(Collection<String> items) {
        this.products = ImmutableList.copyOf(items);
    }

    public static AddProductsToCart called(Collection<String> products) {
        return new AddProductsToCart(products);
    }

    @Step("{0} adds the products name: #products")
    public <T extends Actor> void performAs(T actor) {
        products.forEach(
                product -> actor.attemptsTo(AddAProduct.called(product))
        );
    }
}
