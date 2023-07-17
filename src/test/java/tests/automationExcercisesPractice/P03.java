package tests.automationExcercisesPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P03 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue( driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        System.out.println("Home Page Testi PASSED");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath(" //i[@class='fa fa-lock']")).click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        System.out.println("Login Account Testi PASSED");
        //6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("abc@hotmail.com");
        driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("123456789");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']")).isDisplayed());
        System.out.println("Incorrect info testi PASSED");

    }
}
