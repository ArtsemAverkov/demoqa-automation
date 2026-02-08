package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {

    private WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    // Buttons
    private By expandAllButton = By.cssSelector("button[title='Expand all']");
    private By collapseAllButton = By.cssSelector("button[title='Collapse all']");

    // Titles
    private By homeTitle = By.xpath("//span[@class='rct-title' and text()='Home']");
    private By desktopTitle = By.xpath("//span[@class='rct-title' and text()='Desktop']");
    private By documentsTitle = By.xpath("//span[@class='rct-title' and text()='Documents']");
    private By downloadsTitle = By.xpath("//span[@class='rct-title' and text()='Downloads']");
    private By notesTitle = By.xpath("//span[@class='rct-title' and text()='Notes']");


    // Result block
    private By resultBlock = By.id("result");


    // Checkbox inputs
    private By desktopCheckboxInput =
            By.xpath("//span[text()='Desktop']/ancestor::label/input");

    private By documentsCheckboxInput =
            By.xpath("//span[text()='Documents']/ancestor::label/input");

    private By downloadsCheckboxInput =
            By.xpath("//span[text()='Downloads']/ancestor::label/input");


    // Half-check icons
    private By desktopHalfCheckIcon =
            By.xpath("//span[text()='Desktop']/ancestor::label//*[contains(@class,'rct-icon-half-check')]");


    public void expandAll() {
        driver.findElement(expandAllButton).click();
    }

    public void collapseAll() {
        driver.findElement(collapseAllButton).click();
    }

    public void clickHome() {
        driver.findElement(homeTitle).click();
    }

    public void clickNotes() {
        driver.findElement(notesTitle).click();
    }


    // --- Checked state ---

    private boolean isCheckboxChecked(By inputLocator) {
        return driver.findElement(inputLocator).isSelected();
    }

    public boolean isDesktopChecked() {
        return isCheckboxChecked(desktopCheckboxInput);
    }

    public boolean isDocumentsChecked() {
        return isCheckboxChecked(documentsCheckboxInput);
    }

    public boolean isDownloadsChecked() {
        return isCheckboxChecked(downloadsCheckboxInput);
    }

    // --- Half checked state ---

    public boolean isDesktopHalfChecked() {
        return !driver.findElements(desktopHalfCheckIcon).isEmpty();
    }

    // --- Visibility ---

    private boolean isVisible(By locator) {
        return driver.findElements(locator)
                .stream()
                .anyMatch(WebElement::isDisplayed);
    }

    public boolean isDesktopVisible() {
        return isVisible(desktopTitle);
    }

    public boolean isDocumentsVisible() {
        return isVisible(documentsTitle);
    }

    public boolean isDownloadsVisible() {
        return isVisible(downloadsTitle);
    }

    // --- Result text ---

    public String getResultText() {
        return driver.findElement(resultBlock).getText();
    }
}
