package testsuite;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    /* 3. Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully
* click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’ */


    String baseurl = "https://courses.ultimateqa.com/";

    @Before
    public void setup() {

        openBrowser(baseurl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        //  WebElement clickSignIn = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        // clickSignIn.click();
        String actualMess = getTextFromElement(By.xpath("//h1[text()='Welcome Back!']"));
        String expectedMess = "Welcome Back!";
    /*WebElement verify = driver.findElement(By.xpath("//h1[text()='Welcome Back!']"));
    String actualMess = verify.getText();
    String expectedMess = "Welcome Back!";
    Assert.assertEquals(expectedMess, actualMess);  */
    }

    /*  2. verifyTheErrorMessage
     * click on the ‘Sign In’ link
     * Enter invalid username
     * Enter invalid password
     * Click on Login button
     * Verify the error message ‘Invalid email or password.’*/
    @Test
    public void verifyTheErrorMessage() {
        clickOnElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));

        // WebElement clickSignIn = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        // clickSignIn.click();
        sendTextToElement(By.xpath("//input[@type='email']"), "dhrupestcb1@gmail.com");
        sendKeysToElement(By.xpath("//input[@type='password']"), "12345");
        clickOnElement(By.xpath("//input[@type='submit']"));

        /* WebElement clickusername = driver.findElement(By.xpath("//input[@type='email']"));
         clickusername.sendKeys("dhrupestcb1@gmail.com");
        WebElement clickPassword = driver.findElement(By.xpath("//input[@type='password']"));
        clickPassword.sendKeys("12345");
        WebElement clickLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        clickLogin.click();*/
        String actualMess = getTextFromElement(By.xpath("//li[@role='alert']"));
      
        String expectedMess = "Invalid email or password.";
        Assert.assertEquals(expectedMess, actualMess);
       /* WebElement verify = driver.findElement(By.xpath("//li[@role='alert']"));
        String actMess = verify.getText();
        String expMess = "Invalid email or password.";
        Assert.assertEquals(expMess,actMess);  */


    }
}

