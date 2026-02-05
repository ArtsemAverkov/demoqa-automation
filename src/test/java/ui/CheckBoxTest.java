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

    @Test
    public void desktopCheckBoxShouldBeHalfChecked(){
        driver.get(Endpoint.CHECK_BOX.getPatch());
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.expandAll();
        checkBoxPage.clickNotes();

        Assert.assertTrue(checkBoxPage.isDesktopHalfChecked(), "Desktop не в состоянии half-checked");
    }

    @Test
    public void collapseAllShouldHideChildElements() {
        driver.get(Endpoint.CHECK_BOX.getPatch());
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.expandAll();
        Assert.assertTrue(checkBoxPage.isDesktopVisible(), "Desktop должен быть виден после Expand All");

        checkBoxPage.collapseAll();
        Assert.assertFalse(checkBoxPage.isDesktopVisible(), "Desktop должен быть скрыт после Collapse All");
    }

    @Test
    public void expandAllShouldExpandAllElements(){
        driver.get(Endpoint.CHECK_BOX.getPatch());
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);

        checkBoxPage.expandAll();

        Assert.assertTrue(checkBoxPage.isDesktopVisible(), "Desktop должен быть виден");
        Assert.assertTrue(checkBoxPage.isDocumentsVisible(), "Documents должен быть виден");
        Assert.assertTrue(checkBoxPage.isDownloadsVisible(), "Downloads должен быть виден");
    }

}
