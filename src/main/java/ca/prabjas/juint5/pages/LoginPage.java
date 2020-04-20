package ca.prabjas.juint5.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage extends BasePage {

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements by using Page Factory*********
    @FindBy(how = How.ID, using = "user_login")
    public WebElement username;

    @FindBy(how = How.ID, using = "user_pass")
    public WebElement password;

    @FindBy(how = How.ID, using = "wp-submit")
    public WebElement loginButton;

    @FindBy(how = How.ID, using = "login_error")
    public WebElement errorMessage;

    //*********Page Methods*********
    @Step("And I Login To N11 {pusername} / {ppassword}.")
    public LoginPage AndIloginToN11(String pusername, String ppassword){
        waitForElementToBeClickable(loginButton);
        writeText(username,pusername);
        writeText(password, ppassword);
        click(loginButton);
        return this;
    }

    @Step("Then I Verify Login User Name Error Message : {expectedText}")
    public LoginPage ThenIVerifyLoginUserNameErrorMessage(String expectedText) {

        assertTrue(readText(errorMessage).contains(expectedText));
        return this;
    }

    @Step("Then I Verify Password Error Message : {expectedText}")
    public LoginPage ThenIVerifyPasswordErrorMessage(String expectedText) {
        assertTrue(readText(errorMessage).contains(expectedText));
        return this;
    }
}