package object_behaviors.implementation;

import net.serenitybdd.core.pages.WebElementFacade;
import object_behaviors.rules.Button;

public class ButtonImpl implements Button {
    protected WebElementFacade element;

    public ButtonImpl(WebElementFacade element) {
        this.element = element;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }

    @Override
    public void click() {
        try {
            getWrappedElement().waitUntilClickable().click();
        } catch (Exception e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public boolean isDisabled() {
        try {
            return getWrappedElement().waitUntilVisible().isDisabled();
        } catch (Exception e) {
            return false;
        }
    }
}
