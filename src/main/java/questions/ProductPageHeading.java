package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.questions.Text;

import static pages.ProductPage.PAGE_TITLE;

@Subject("The heading displayed text")
public class ProductPageHeading implements Question<String> {

    public static ProductPageHeading textHeading() {
        return new ProductPageHeading();
    }

    @Override
    public String answeredBy(Actor actor) {
        String text = actor.asksFor(Text.of(PAGE_TITLE));
        return text;
    }
}
