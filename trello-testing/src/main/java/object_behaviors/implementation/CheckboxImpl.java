package object_behaviors.implementation;

import net.serenitybdd.core.pages.WebElementFacade;
import object_behaviors.rules.Checkbox;

public class CheckboxImpl implements Checkbox {
    protected WebElementFacade element;

    public CheckboxImpl(WebElementFacade element) {
        this.element = element;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }

    @Override
    public void check() {
        try {
            if (!getWrappedElement().isSelected()) {
                getWrappedElement().click();
            }
        } catch (Exception e) {
            throw new IllegalStateException("Unable to check checkbox: " + e.getMessage());
        }
    }

    @Override
    public void uncheck() {
        try {
            if (getWrappedElement().isSelected()) {
                getWrappedElement().click();
            }
        } catch (Exception e) {
            throw new IllegalStateException("Unable to uncheck checkbox: " + e.getMessage());
        }
    }
}
