package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RadioButtonPage;
import utills.Endpoint;

public class RadioButtonTest extends BaseTest {

    @Test
    public void shouldSelectYesRadioButton(){
        driver.get(Endpoint.RADIO_BUTTON.getPatch());
        RadioButtonPage radioButtonPage = new RadioButtonPage(driver);

        radioButtonPage.clickYes();

        Assert.assertTrue(radioButtonPage.isYesSelected());
        Assert.assertEquals(radioButtonPage.getResultText(), "Yes");

    }
}
