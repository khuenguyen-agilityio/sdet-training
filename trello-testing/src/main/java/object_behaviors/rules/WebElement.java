package object_behaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public interface WebElement {
    WebElementFacade getWrappedElement();

    void click();

    boolean isVisible();

    WebElementFacade waitUntilVisible(Duration waitAtMost);

    WebElementFacade waitUntilVisible(Duration waitAtMost, Duration interval);

    WebElementFacade waitUntilNotVisible(Duration waitAtMost);

    WebElementFacade waitUntilNotVisible(Duration waitAtMost, Duration interval);

    String getText();
}
