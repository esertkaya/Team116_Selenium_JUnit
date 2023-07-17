package tests.automationExcercisesPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P02 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue( driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        System.out.println("Home Page Test PASSED");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath(" //i[@class='fa fa-lock']")).click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        System.out.println("Login Account Testi PASSED");
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("ea@hotmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345678");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath(" //*[@class='fa fa-user'] ")).isDisplayed());
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath(" //*[text()=' Delete Account'] ")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        System.out.println("Account Deleted Testi PASSED");

    }
}
