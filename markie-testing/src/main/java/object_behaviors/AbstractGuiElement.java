package object_behaviors;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public abstract class AbstractGuiElement extends PageObject implements IGuiElement {
    protected String name;
    protected WebElementFacade element;

    public AbstractGuiElement(WebElementFacade element) {
        this.element = element;
    }

    public AbstractGuiElement(WebElementFacade element, String name) {
        this(element);
        this.name = name;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }
}
