package actions;

import helpers.Storage;
import pages.BoardPage;

import static contants.StorageKey.TEST_LABEL;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardPageActions {
    private BoardPage boardPage;

    /**
     * Click on a card with given title
     *
     * @param title
     */
    public void clickCardWithTitle(String title) {
        // wait for the card with given title visible and click it
        boardPage.testCard(title).getWrappedElement().waitUntilVisible().click();
    }

    /**
     * Create new card with given label and save label to Storage
     *
     * @param label
     */
    public void createNewCardLabel(String label) {
        boardPage.buttonLabels().getWrappedElement().waitUntilVisible().click();
        boardPage.buttonLabelsAction("Create a new label").click();
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
}
