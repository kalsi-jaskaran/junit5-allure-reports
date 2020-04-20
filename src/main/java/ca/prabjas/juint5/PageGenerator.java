package ca.prabjas.juint5;

import ca.prabjas.juint5.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class PageGenerator {
    public WebDriver driver;

    public PageGenerator(WebDriver driver){
        this.driver = driver;
    }

    //JAVA Generics to Create and return a New Page
    public  <TPage extends BasePage> TPage getPage (Class<TPage> pageClass) {
        try {
            //Initialize the Page with its elements and return it.
            // PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(30)),  pageClass);
            return PageFactory.initElements(driver,  pageClass);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                throw e;
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return null;
    }
}
