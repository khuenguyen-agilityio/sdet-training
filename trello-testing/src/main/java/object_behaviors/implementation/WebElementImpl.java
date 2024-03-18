package object_behaviors.implementation;

import net.serenitybdd.core.pages.WebElementFacade;
import object_behaviors.rules.WebElement;
import org.awaitility.Awaitility;

import java.time.Duration;

public class WebElementImpl implements WebElement {
    protected WebElementFacade element;

    public WebElementImpl(WebElementFacade element) {
        this.element = element;
    }

    @Override
    public WebElementFacade getWrappedElement() {
        return this.element;
    }

    @Override
    public void click() {
        getWrappedElement().click();
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
    public void waitUntilVisible(Duration waitAtMost) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(Duration.ofMillis(500))
                .until(() -> isVisible() == true);
    }

    @Override
    public void waitUntilVisible(Duration waitAtMost, Duration interval) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(interval)
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
    public void waitUntilNotVisible(Duration waitAtMost, Duration interval) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(interval)
                .until(() -> isVisible() == false);
    }

    @Override
    public String getText() {
        return getWrappedElement().getText();
    }
}
