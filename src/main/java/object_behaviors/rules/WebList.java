package object_behaviors.rules;

import net.serenitybdd.core.pages.ListOfWebElementFacades;

import java.time.Duration;
import java.util.List;

public interface WebList {
    ListOfWebElementFacades getListWrappedElements();

    List<String> getTexts();

    boolean isContainElementWithText(String text);

    ListOfWebElementFacades waitUntilContainElementWithTextVisible(Duration waitAtMost, Duration interval, String text);

    void selectElements(int count);
}
