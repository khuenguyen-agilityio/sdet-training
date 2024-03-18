package object_behaviors.implementation;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import object_behaviors.rules.WebList;

import java.util.ArrayList;
import java.util.List;

public class WebListImpl implements WebList {
    protected ListOfWebElementFacades elements;

    public WebListImpl(ListOfWebElementFacades elements) {
        this.elements = elements;
    }

    @Override
    public ListOfWebElementFacades getWrappedElements() {
        return this.elements;
    }

    @Override
    public List<String> getTexts() {
        List<String> lists = new ArrayList<String>();
        getWrappedElements().forEach(element -> lists.add(element.getText()));
        return lists;
    }
}
