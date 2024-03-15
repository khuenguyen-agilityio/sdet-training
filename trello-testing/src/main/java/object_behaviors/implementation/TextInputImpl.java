package object_behaviors.implementation;

import net.serenitybdd.core.pages.WebElementFacade;
import object_behaviors.rules.TextInput;

public class TextInputImpl implements TextInput {
    protected WebElementFacade element;

    public TextInputImpl(WebElementFacade element) {
        this.element = element;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }

    @Override
    public void type(String text) {
        getWrappedElement().waitUntilVisible().sendKeys(text);
    }

    @Override
    public void typeAndEnter(String text) {
        getWrappedElement().waitUntilVisible().typeAndEnter(text);
    }

    @Override
    public void clearAndType(String text) {
        getWrappedElement().waitUntilVisible().clear();
        getWrappedElement().sendKeys(text);
    }
}
