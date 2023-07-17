package tests.automationExcercisesPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P13 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue( driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        System.out.println("Home Page Testi PASSED");
        //4. Click 'View Product' for any product on home page
        Actions action=new Actions(driver);
        action.scrollToElement(driver.findElement(By.xpath("(//*[@class='productinfo text-center'])[4]"))).perform();
        bekle(3);
        driver.findElement(By.xpath("(//*[text()='View Product'])[4]")).click();
        //5. Verify product detail is opened
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-information']")).isEnabled());
        //6. Increase quantity to 4
        WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity']"));
        quantity.clear();
        quantity.sendKeys("4");

       /* WebElement quantity = driver.findElement(By.xpath("//input[@id='quantity']"));
        String expectedQuantity = "4";
        for (int i = 1; i < Integer.parseInt(expectedQuantity); i++) {
            quantity.sendKeys(Keys.ARROW_UP);
        }
        */
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//button[@type='button']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        Assert.assertTrue(driver.findElement(By.id("product-4")).isDisplayed());
    }
}

