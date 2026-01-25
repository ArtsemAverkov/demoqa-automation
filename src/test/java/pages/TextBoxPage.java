package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {

    private WebDriver driver;

    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    private WebElement fullName;

    @FindBy(id = "userEmail")
    private WebElement email;

    @FindBy(id = "currentAddress")
    private WebElement currentAddress;

    @FindBy(id = "permanentAddress")
    private WebElement permanentAddress;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    @FindBy(id = "output")
    private WebElement output;

    public void fillForm(String name, String emailText, String currAddr, String permAddr){
        fullName.sendKeys(name);
        email.sendKeys(emailText);
        currentAddress.sendKeys(currAddr);
        permanentAddress.sendKeys(permAddr);
    }

    public void submitForm(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", submitBtn);

        submitBtn.click();
    }

    public String getOutputText(){
        return output.getText();
    }

    public String getEmailValue(){
        return email.getAttribute("value");
    }

    public boolean isOutputDisplayed(){
        return driver.findElements(By.id("output")).isEmpty();
    }

    public boolean isEmailFieldInvalid(){
        return email.getAttribute("class").contains("field-error");
    }

    public String getNameValue(){
        return fullName.getAttribute("value");
    }
}
