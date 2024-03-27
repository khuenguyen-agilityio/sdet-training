package tasks.add_product;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static pages.ProductPage.ADD_TO_CARD;

public class AddAProduct {
    public static Task called(String product) {
        return Task.where("{0} add a product with name: " + product,
                Click.on(ADD_TO_CARD.of(product)));
    }
}
