package helpers;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.awaitility.Awaitility;
import org.openqa.selenium.NoSuchElementException;

import java.time.Duration;

@Slf4j
public abstract class AbstractGuiElement extends PageObject implements IGuiElement {

    protected String name;
    protected WebElementFacade element;

    public AbstractGuiElement(WebElementFacade element) {
        this.element = element;
    }

    public AbstractGuiElement(WebElementFacade element, String name) {
        this(element);
        this.name = name;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }

    @Override
    public void click() {
        try {
            getWrappedElement().waitUntilClickable().click();
        } catch (NoSuchElementException e) {
            log.error("Element should be [Clickable]", e);
            throw new IllegalStateException(e.getMessage());
        }
    }

    @Override
    public String getText() {
        return getWrappedElement().getText();
    }

    @Override
    public boolean isPresent() {
        try {
            return getWrappedElement().isPresent();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isVisible() {
        try {
            return getWrappedElement().isVisible();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isClickable() {
        try {
            return getWrappedElement().isClickable();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isAttributeValuePresent(String attributeName) {
        try {
            if (null != getWrappedElement().getAttribute(attributeName)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public void waitUntilVisible(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isVisible() == true);
    }

    @Override
    public void waitUntilNotVisible(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isVisible() == false);
    }

    @Override
    public void waitUntilClickable(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isClickable() == true);
    }
}
