package helpers;

import org.openqa.selenium.WrapsElement;

import java.time.Duration;

public interface IGuiElement extends WrapsElement {
    void click();

    String getText();

    boolean isPresent();

    boolean isVisible();

    boolean isClickable();

    boolean isAttributeValuePresent(String attribute);

    void waitUntilVisible(Duration waitAtMost);

    void waitUntilNotVisible(Duration waitAtMost);

    void waitUntilClickable(Duration waitAtMost);
}
