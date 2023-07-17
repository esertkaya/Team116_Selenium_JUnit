package tests.automationExcercisesPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class P05 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        System.out.println("HP Test PASSED");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
        System.out.println("New User Testi PASSED");
        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("Elif");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("efhykz@hotmail.com");
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());
        System.out.println("Test PASSED");
    }


}
