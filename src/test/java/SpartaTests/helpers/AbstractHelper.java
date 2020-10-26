package SpartaTests.helpers;

import SpartaTests.pages.AbstractPage;

class AbsractHelper {
    AbstractPage abstractPage = new AbstractPage();

    public void quite() {
        abstractPage.getDriver().quit();
    }
}

