package object_behaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

public interface TextInput {
    WebElementFacade getWrappedElement();

    void type(String text);

    void typeAndEnter(String text);

    void clearAndType(String text);
}
