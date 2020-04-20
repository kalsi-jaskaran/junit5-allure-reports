package ca.prabjas.juint5.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "https://s1.demo.opensourcecms.com/wordpress/";

    //*********Web Elements By Using Page Factory*********
    @FindBy(how = How.LINK_TEXT, using = "Log in")
    public WebElement signInButton;

    //*********Page Methods*********
    //Go to Homepage
    @Step("Given I Am At HomePage")
    public HomePage GivenIAmAtHomePage(){
        driver.get(baseURL);
        return this;
    }

    //Go to LoginPage
    @Step("When I Go To Login Page")
    public LoginPage WhenIGoToLoginPage(){
        click(signInButton);
        return PageFactory.initElements(driver, LoginPage.class);
    }
}