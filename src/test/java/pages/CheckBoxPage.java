package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utills.Endpoint;

public class CheckBoxPage {

    private WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    private By expandAllButton = By.cssSelector("button[title='Expand all']");
    private By collapseAllButton = By.cssSelector("button[title='Collapse all']");

    private By homeCheckbox = By.xpath("//span[@class='rct-title' and text()='Home']");
    private By desktopCheckBox = By.xpath("//span[@class='rct-title' and text()='Desktop']");
    private  By desktopNode = By.xpath("//span[@class='rct-title' and text()='Desktop']");
    private By documentsCheckBox = By.xpath("//span[@class='rct-title' and text()='Documents']");
    private By downloadsCheckBox = By.xpath("//span[@class='rct-title' and text()='Downloads']");
    private By selectedNestedItem = By.xpath("//span[@class='rct-title' and text()='Notes']");

    private By resultBlock = By.id("result");

    private By desktopHalfCheckedIcon =
            By.xpath("//span[text()='Desktop']" +
                    "/ancestor::label" +
                    "//*[contains(@class,'rct-icon-half-check')]");


    public  void open(){
        driver.get(Endpoint.CHECK_BOX.getPatch());
    }

    public void expandAll(){
        driver.findElement(expandAllButton).click();
    }

    public void collapseAll(){
        driver.findElement(collapseAllButton).click();
    }

    public void clickHome(){
        driver.findElement(homeCheckbox).click();
    }

    public String getResultText(){
        return driver.findElement(resultBlock).getText();
    }

    public void clickNotes(){
        driver.findElement(selectedNestedItem).click();
    }

    public boolean isDesktopHalfChecked(){
        return !driver.findElements(desktopHalfCheckedIcon).isEmpty();
    }

    public boolean isNodeVisible(By locator){
        return driver.findElements(locator)
                .stream()
                .anyMatch(WebElement::isDisplayed);
    }

    public boolean isDesktopVisible() {
        return isNodeVisible(desktopNode);
    }

    public  boolean isDocumentsVisible(){
        return isNodeVisible(documentsCheckBox);
    }

    public boolean isDownloadsVisible() {
        return isNodeVisible(downloadsCheckBox);
    }

}
