package object_behaviors;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WrapsElement;

public interface IGuiElement extends WrapsElement {

    WebElementFacade getWrappedElement();
}
