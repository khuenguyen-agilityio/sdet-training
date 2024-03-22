package actions;

import pages.HomePage;

public class HomePageActions {
    private HomePage homePage;


    /**
     * Click on the board with given name
     *
     * @param name
     */
    public void clickBoard(String name) {
        // wait for the board with given name visible and click
        homePage.board(name).click();
    }
}
