package object_behaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

public interface Checkbox {
    WebElementFacade getWrappedElement();

    void check();

    void uncheck();
}
