package object_behaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

public interface WebElement {
    WebElementFacade getWrappedElement();

    void click();

    boolean isVisible();

    void waitUntilVisible(Duration waitAtMost);

    void waitUntilVisible(Duration waitAtMost, Duration interval);

    void waitUntilNotVisible(Duration waitAtMost);

    void waitUntilNotVisible(Duration waitAtMost, Duration interval);

    String getText();
}
