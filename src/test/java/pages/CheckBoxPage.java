package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utills.Endpoint;

public class CheckBoxPage {

    private WebDriver driver;

    public CheckBoxPage(WebDriver driver) {
        this.driver = driver;
    }

    private By expandAllButton = By.cssSelector("button[title='Expand all']");
    private By collapseAllButton = By.cssSelector("button[title='Collapse all']");

    private By homeCheckbox = By.xpath("//span[@class='rct-title' and text()='Home']");

    private By selectedNestedItem = By.xpath("//span[@class='rct-title' and text()='Notes']");

    private By resultBlock = By.id("result");

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
}
