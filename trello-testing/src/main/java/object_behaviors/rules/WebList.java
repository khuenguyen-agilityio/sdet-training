package object_behaviors.rules;

import net.serenitybdd.core.pages.ListOfWebElementFacades;

import java.util.List;

public interface WebList {
    ListOfWebElementFacades getWrappedElements();

    List<String> getTexts();
}
