package pages;

import contants.AppConstants;
import net.serenitybdd.core.pages.PageObject;
import object_behaviors.implementation.ButtonImpl;
import object_behaviors.rules.Button;

public class TrelloPage extends PageObject {
    private final String login_link = "//a[text()='%s' and @data-uuid='%s']";

    public Button buttonLogin(String text) {
        String formattedElement = String.format(login_link, text, AppConstants.TRELLO_LOGIN_LINK_UUID);
        return new ButtonImpl($(formattedElement));
    }
}
