package pages;

import contants.AppConstants;
import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.WebElementImpl;
import object_behaviors.rules.WebElement;

public class HomePage extends PageObject {
    private final String login_link = "//a[text()='%s' and @data-uuid='%s']";

    public WebElement loginLink(String text) {
        String formattedElement = String.format(login_link, text, AppConstants.TRELLO_LOGIN_LINK_UUID);
        return new WebElementImpl($(formattedElement));
    }
}
