package testsuits;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utility;

public class Testsuit extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //* click on the ‘Sign In’ link
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));


        // * Verify the text ‘Welcome Back!'
        String accmess = getTextFromElement(By.xpath("//h1[@class='page__heading']"));
        String expmess = "Welcome Back!";

        Assert.assertEquals(expmess, accmess);
    }

    @Test
    public void verifyTheErrorMessage() {
        // * click on the ‘Sign In’ link
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));

        //* Enter invalid username
        sendKeysToElement(By.xpath("//input[@id='user[email]']"), "test@gmail.com");

        //* Enter invalid password
        sendKeysToElement(By.xpath("//input[@id='user[password]']"), "123456");


        // * Click on Login button
        clickOnElement(By.xpath("//input[@class='button button-primary g-recaptcha']"));


        // * Verify the error message ‘Invalid email or password.’
        String accmess = getTextFromElement(By.xpath("//div[@class='notice__form-error']"));
        String expmess = "Invalid email or password.";

        Assert.assertEquals(expmess, accmess);


    }

    @After
    public void teardown() {
        closeBrowser();
    }
}





