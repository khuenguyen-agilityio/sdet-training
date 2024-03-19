package object_behaviors.implementation;

import net.serenitybdd.core.pages.ListOfWebElementFacades;
import object_behaviors.rules.WebList;
import org.awaitility.Awaitility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class WebListImpl implements WebList {
    protected ListOfWebElementFacades elements;

    public WebListImpl(ListOfWebElementFacades elements) {
        this.elements = elements;
    }

    @Override
    public ListOfWebElementFacades getListWrappedElements() {
        return this.elements;
    }

    @Override
    public List<String> getTexts() {
        List<String> lists = new ArrayList<String>();
        getListWrappedElements().forEach(element -> lists.add(element.getText()));
        return lists;
    }

    @Override
    public boolean isContainElementWithText(String text) {
        AtomicBoolean isContain = new AtomicBoolean(false);
        getListWrappedElements().forEach(elements -> {
            if (elements.getWrappedElement().getText().equals(text)) {
                isContain.set(true);
            }
        });
        return isContain.get();
    }

    @Override
    public ListOfWebElementFacades waitUntilContainElementWithTextVisible(Duration waitAtMost, Duration interval, String text) {
        Awaitility.await()
                .atMost(waitAtMost)
                .with()
                .ignoreExceptions()
                .pollInterval(interval)
                .until(() -> isContainElementWithText(text) == true);
        return this.elements;
    }

    @Override
    public void selectElements(int count) {
        AtomicInteger index = new AtomicInteger();
        getListWrappedElements().forEach(element -> {
            if (index.get() < count) {
                element.getWrappedElement().click();
            }
            index.getAndIncrement();
        });
    }
}
