package object_behaviors.implementation;

import net.serenitybdd.core.pages.WebElementFacade;
import object_behaviors.rules.WebElement;

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
    public void sendKeys(String text) {
        getWrappedElement().clear();
        getWrappedElement().sendKeys(text);
    }

    @Override
    public void typeAndEnter(String text) {
        getWrappedElement().typeAndEnter(text);
    }

    @Override
    public boolean isDisplayed() {
        return getWrappedElement().isDisplayed();
    }
}
