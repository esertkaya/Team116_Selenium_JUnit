package tests.automationExcercisesPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P04 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        System.out.println("HomePage test PASSED");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        System.out.println("Login Testi PASSED");
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("efhykz@hotmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345678");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        //8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-user']")).isDisplayed());
        System.out.println("PASSED");
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();
        //10. Verify that user is navigated to login page
        Assert.assertTrue(driver.findElement(By.xpath("//body[@aria-hidden='false']")).isDisplayed());
        System.out.println("PASSED");

    }
}
