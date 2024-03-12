package actions;

import helpers.Storage;
import org.assertj.core.api.SoftAssertions;
import pages.BoardPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static contants.StorageKey.*;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardPageActions {
    private BoardPage boardPage;

    /**
     * Click on a card with given title
     *
     * @param title
     */
    public void clickCardWithTitle(String title) {
        boardPage.testCard(title).getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Click on Label button in the right label sidebar
     */
    public void clickLabelButton() {
        boardPage.buttonLabels().getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Click on button label action with given text
     *
     * @param text
     */
    public void clickButtonLabelAction(String text) {
        boardPage.buttonLabelsAction(text).click();
    }

    /**
     * Click on button remove color
     */
    public void clickButtonRemoveColor() {
        boardPage.buttonRemoveColor().click();
    }

    /**
     * Create new card with given label and save label to Storage
     *
     * @param label
     */
    public void createNewCardLabel(String label) {
        boardPage.inputLabelTitle().getWrappedElement().sendKeys(label);
        boardPage.buttonLabelsAction("Create").click();

        Storage.getStorage().saveObjectValue(TEST_LABEL, label);
    }

    /**
     * Verify new card label title by compare it with data form Storage
     */
    public void verifyCardLabelTitle() {
        String label = (String) Storage.getStorage().getObject(TEST_LABEL);
        assertThat(boardPage.cardLabel().getWrappedElement().getText()).isEqualTo(label);
    }

    /**
     * Verify the card with given title is disabled
     *
     * @param title
     */
    public void verifyButtonLabelsActionIsDisabled(String title) {
        assertThat(boardPage.buttonLabelsAction(title).getWrappedElement().waitUntilVisible().isDisabled()).isTrue();
    }

    /**
     * Delete test card with title form Storage
     */
    public void deleteTestLabel() {
        // get label from storage
        String label = (String) Storage.getStorage().getObject(TEST_LABEL);

        // wait for button edit visible and click delete button twice
        boardPage.buttonEditLabel(label).getWrappedElement().waitUntilVisible().click();
        boardPage.buttonLabelsAction("Delete").click();
        boardPage.buttonLabelsAction("Delete").click();
    }

    /**
     * Click on the Checklist button to open checklist menu
     */
    public void clickChecklistButton() {
        boardPage.buttonChecklist().getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Create new checklist with given title
     *
     * @param title
     */
    public void createNewChecklist(String title) {
        boardPage.inputChecklistTitle().getWrappedElement().waitUntilVisible().sendKeys(title);
        boardPage.buttonSubmit("Add").click();

        Storage.getStorage().saveObjectValue(TEST_CHECKLIST_HEADING, title);
    }

    /**
     * Create checklist items with following items
     * Browsing through item in the items list to create it
     *
     * @param items
     */
    public void createNewChecklistItem(List<String> items) {
        for (String item : items) {
            boardPage.inputChecklistItem().getWrappedElement().waitUntilVisible().sendKeys(item);
            boardPage.buttonAddChecklistItem().click();
        }
        boardPage.buttonCancelAddChecklistItem().click();
        Storage.getStorage().saveObjectValue(TEST_CHECKLIST_ITEMS, items);
    }

    /**
     * Verify the checklist
     * Verify the heading has been created with value from Storage
     * Verify the items has been created with the value from Storage
     */
    public void verifyChecklist() {
        // wait for heading visible
        boardPage.checklistHeading().getWrappedElement().waitUntilVisible();
        String heading = (String) Storage.getStorage().getObject(TEST_CHECKLIST_HEADING);

        // wait for button cancel invisible (all item is ready)
        boardPage.buttonCancelAddChecklistItem().getWrappedElement().waitUntilNotVisible();

        // create compare list
        List<String> createdItems = new ArrayList<>();
        List<String> items = (List<String>) Storage.getStorage().getObject(TEST_CHECKLIST_ITEMS);
        boardPage.checklistItems().forEach(element -> createdItems.add(element.getText()));

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(boardPage.checklistHeading().getWrappedElement().getText()).isEqualTo(heading);
        assertions.assertThat(items.equals(createdItems)).isTrue();
        assertions.assertAll();
    }

    /**
     * Delete the checklist created
     */
    public void deleteChecklist() {
        boardPage.buttonDeleteChecklist().getWrappedElement().waitUntilVisible().click();
        boardPage.buttonConfirmDeleteChecklist().getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Tick the checkbox of checklist item with the index smaller than given count
     *
     * @param count
     */
    public void tickCheckboxItems(int count) {
        // wait for button cancel invisible (all item is ready)
        boardPage.buttonCancelAddChecklistItem().getWrappedElement().waitUntilNotVisible();

        AtomicInteger index = new AtomicInteger();
        boardPage.checkboxChecklist().forEach(checkbox -> {
            if (index.get() < count) {
                checkbox.waitUntilVisible().click();
            }
            index.getAndIncrement();
        });
    }

    /**
     * Verify the checklist progress percent displayed the given percent
     *
     * @param percent
     */
    public void verifyChecklistProgress(int percent) {
        String text = percent + "%";
        assertThat(boardPage.checklistProgressPercent().getWrappedElement().waitUntilVisible().getText()).isEqualTo(text);
    }

    /**
     * Verify the checklist items is empty (no item in the list)
     */
    public void verifyChecklistItemsIsEmpty() {
        assertThat(boardPage.checklistItemContainer().getWrappedElement().getText().isEmpty()).isTrue();
    }
}
