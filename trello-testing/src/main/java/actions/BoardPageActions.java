package actions;

import pages.BoardPage;

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
}
