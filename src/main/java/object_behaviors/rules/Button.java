package object_behaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

public interface Button {
    WebElementFacade getWrappedElement();

    void click();

    boolean isDisabled();
}
