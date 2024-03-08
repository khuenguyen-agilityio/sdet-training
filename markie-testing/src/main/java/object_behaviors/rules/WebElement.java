package object_behaviors.rules;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WrapsElement;

public interface WebElement {
    WebElementFacade getWrappedElement();

    void click();

    void sendKeys(String text);

    void typeAndEnter(String text);

    boolean isDisplayed();
}
