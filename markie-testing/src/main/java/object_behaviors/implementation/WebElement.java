package object_behaviors.implementation;

import net.serenitybdd.core.pages.WebElementFacade;
import object_behaviors.AbstractGuiElement;
import object_behaviors.rules.IWebElement;

public class WebElement extends AbstractGuiElement implements IWebElement {
    private final WebElementFacade element;

    public WebElement(WebElementFacade element) {
        super(element);
        this.element = element;
    }

    public WebElement(WebElementFacade element, String name) {
        super(element, name);
        this.element = element;
    }
}
