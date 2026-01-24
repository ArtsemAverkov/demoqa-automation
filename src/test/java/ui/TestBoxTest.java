package ui;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;

public class TestBoxTest extends BaseTest {

    @Test
    public void positiveTextBoxTest(){
        driver.get("https://demoqa.com/text-box");

        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.fillForm(
                "John Doe", "john@example.com", "123 Main St", "456 Elm St");
        textBoxPage.submitForm();

        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains("John Doe"));
        Assert.assertTrue(outputText.contains("john@example.com"));
    }
}
