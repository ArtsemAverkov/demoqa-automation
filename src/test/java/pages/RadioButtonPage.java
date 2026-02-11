package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage {

    private WebDriver driver;

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
    }

    private By yesLabel = By.cssSelector("label[for='yesRadio']");
    private By impressiveLable = By.cssSelector("label[for='impressiveRadio']");
    private By noRadioInput = By.id("noRadio");

    private By yesInput = By.id("yesRadio");
    private By impressiveInput = By.id("impressiveRadio");

    private By resultText = By.className("text-success");



    public void clickYes(){
        driver.findElement(yesLabel).click();
    }

    public void clickImpressive(){
        driver.findElement(impressiveLable).click();
    }


    public boolean isYesSelected(){
        return driver.findElement(yesInput).isSelected();
    }

    public String getResultText(){
        return driver.findElement(resultText).getText();
    }

}
