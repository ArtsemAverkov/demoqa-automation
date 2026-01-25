package ui;

import core.BaseTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import utills.Endpoint;
import utills.TestUserScenario;
import utills.models.UserDto;
import utills.users.ParameterResolverUser;


@DisplayName("Positive test Text_box")
public class TestBoxTest extends BaseTest {


    @Test
    public void positiveTextBoxTest(){

        driver.get(Endpoint.TEXT_BOX.getPatch());
        UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.VALID_DATA.getDataUser());
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.fillForm(
                validUser.name,
                validUser.email,
                validUser.currentAddress,
                validUser.permanentAddress);
        textBoxPage.submitForm();

        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains(validUser.name));
        Assert.assertTrue(outputText.contains(validUser.email));
    }

    @Test
    public void positivePartialFormTest (){
        UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.ONLY_NAME_AND_EMAIL.getDataUser());
        driver.get(Endpoint.TEXT_BOX.getPatch());
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.fillForm(
                validUser.name,
                validUser.email,
                validUser.currentAddress,
                validUser.permanentAddress);
        textBoxPage.submitForm();

        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains(validUser.name));
        Assert.assertTrue(outputText.contains(validUser.email));
    }

    @Test
    public void positiveMaxLengthTest(){
        UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.LONG_USERNAME.getDataUser());
        driver.get(Endpoint.TEXT_BOX.getPatch());
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.fillForm(validUser.name,
                validUser.email,
                validUser.currentAddress,
                validUser.permanentAddress);
        textBoxPage.submitForm();

        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains(validUser.name));
    }

    @Test
    public void positiveMinLengthTest(){
        UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.SMALL_USERNAME.getDataUser());
        driver.get(Endpoint.TEXT_BOX.getPatch());
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.fillForm(validUser.name,
                validUser.email,
                validUser.currentAddress,
                validUser.permanentAddress);
        textBoxPage.submitForm();

        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains(validUser.name));
        }

    @Test
    public void positiveSpecialCharsTest(){
        UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.SPECIAL_CHARS.getDataUser());
        driver.get(Endpoint.TEXT_BOX.getPatch());
        TextBoxPage textBoxPage = new TextBoxPage(driver);

        textBoxPage.fillForm(
                validUser.name,
                validUser.email,
                validUser.currentAddress,
                validUser.permanentAddress);
        textBoxPage.submitForm();

        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains(validUser.name));
    }

    @Nested
    @DisplayName("Negative test Text_box")
    class NegativeTestBoxTest extends BaseTest{

        @Test
        public void negativeEmptyNameTest(){
            UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.EMPTY_NAME.getDataUser());
            driver.get(Endpoint.TEXT_BOX.getPatch());
            TextBoxPage textBoxPage = new TextBoxPage(driver);

            textBoxPage.fillForm(
                    validUser.name,
                    validUser.email,
                    validUser.currentAddress,
                    validUser.permanentAddress);
            textBoxPage.submitForm();

            Assert.assertFalse(textBoxPage.isOutputDisplayed());
        }

        @Test
        public void negativeInvalidEmailTestWhereFormNotSend(){
            UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.INVALID_EMAIL.getDataUser());
            driver.get(Endpoint.TEXT_BOX.getPatch());
            TextBoxPage textBoxPage = new TextBoxPage(driver);

            textBoxPage.fillForm(
                    validUser.name,
                    validUser.email,
                    validUser.currentAddress,
                    validUser.permanentAddress
            );
            textBoxPage.submitForm();

            //Форма не отправилась
            Assert.assertFalse(textBoxPage.isOutputDisplayed());
        }

        @Test
        public void negativeInvalidEmailTestWhereFormIsHighlighted(){
            UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.INVALID_EMAIL.getDataUser());
            driver.get(Endpoint.TEXT_BOX.getPatch());
            TextBoxPage textBoxPage = new TextBoxPage(driver);

            textBoxPage.fillForm(
                    validUser.name,
                    validUser.email,
                    validUser.currentAddress,
                    validUser.permanentAddress
            );
            textBoxPage.submitForm();

            // Форма для ввода Email подсвечена
            Assert.assertTrue(textBoxPage.isEmailFieldInvalid());

        }

        @Test
        public void negativeInvalidEmailTestWhereNoDataLost(){
            UserDto validUser = ParameterResolverUser.getUser(TestUserScenario.INVALID_EMAIL.getDataUser());
            driver.get(Endpoint.TEXT_BOX.getPatch());
            TextBoxPage textBoxPage = new TextBoxPage(driver);

            textBoxPage.fillForm(
                    validUser.name,
                    validUser.email,
                    validUser.currentAddress,
                    validUser.permanentAddress
            );
            textBoxPage.submitForm();

            // Данные не потерялись
            Assert.assertEquals(textBoxPage.getNameValue(),validUser.name);
        }



    }


}
