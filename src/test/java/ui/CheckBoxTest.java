package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;
import utills.Endpoint;

public class CheckBoxTest extends BaseTest {

     @Test
    public void selectHomeCheckBoxTest(){
         driver.get(Endpoint.CHECK_BOX.getPatch());
         CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

         checkBoxPage.clickHome();

         String result = checkBoxPage.getResultText();
         Assert.assertTrue(result.contains("home"), "Result не содержит 'home'");
     }


    @Test
    public void selectNotesCheckBoxTest(){
         driver.get(Endpoint.CHECK_BOX.getPatch());
         CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

         checkBoxPage.expandAll();
         checkBoxPage.clickNotes();

        String resultText = checkBoxPage.getResultText();
        Assert.assertTrue(resultText.contains("notes"), "Result не содержит 'notes'");


    }
}
