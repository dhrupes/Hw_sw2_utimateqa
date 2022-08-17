package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DynAnyPackage.Invalid;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    /* 3. Write down the following test into ‘LoginTest’ class
1. userShouldNavigateToLoginPageSuccessfully
* click on the ‘Sign In’ link
* Verify the text ‘Welcome Back!’ */



 String baseurl = "https://courses.ultimateqa.com/";
@Before
public void setup(){

    openBrowser(baseurl);
}
@Test
public void userShouldNavigateToLoginPageSuccessfully() {
    WebElement clickSignIn = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
    clickSignIn.click();
    WebElement verify = driver.findElement(By.xpath("//h1[text()='Welcome Back!']"));
    String actualMess = verify.getText();
    String expectedMess = "Welcome Back!";
    Assert.assertEquals(expectedMess, actualMess);
}
  /*  2. verifyTheErrorMessage
            * click on the ‘Sign In’ link
            * Enter invalid username
            * Enter invalid password
            * Click on Login button
            * Verify the error message ‘Invalid email or password.’*/
    @Test
            public void verifyTheErrorMessage(){
        WebElement clickSignIn = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        clickSignIn.click();
         WebElement clickusername = driver.findElement(By.xpath("//input[@type='email']"));
         clickusername.sendKeys("dhrupestcb1@gmail.com");
        WebElement clickPassword = driver.findElement(By.xpath("//input[@type='password']"));
        clickPassword.sendKeys("12345");
        WebElement clickLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        clickLogin.click();
        WebElement verify = driver.findElement(By.xpath("//li[@role='alert']"));
        String actMess = verify.getText();
        String expMess = "Invalid email or password.";
        Assert.assertEquals(expMess,actMess);


    }
}

