package tests.automationExcercisesPractice;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P14 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue( driver.findElement(By.xpath("//section[@id='slider']")).isDisplayed());
        System.out.println("Home Page Testi PASSED");
        //4. Add products to cart
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[7]"))).perform();
        actions = new Actions(driver);
        actions.click(driver.findElement(By.xpath("(//*[text()='Add to cart'])[1]"))).perform();
        driver.findElement(By.xpath("//*[text()='Continue Shopping']")).click();
        //5. Click 'Cart' button
        actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        //6. Verify that cart page is displayed
        Assert.assertTrue(driver.findElement(By.id("cart_items")).isDisplayed());
        //7. Click Proceed To Checkout
        driver.findElement(By.xpath("//a[text()='Proceed To Checkout']")).click();
        //8. Click 'Register / Login' button
        driver.findElement(By.xpath("//*[text()='Register / Login']")).click();
        //9. Fill all details in Signup and create account
        Faker faker=new Faker();
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//*[@data-qa='signup-email']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//*[@data-qa='signup-button']")).click();
        bekle(5);
        driver.findElement(By.xpath("//input[@id='id_gender2']")).click();
        String password1=faker.internet().password();
        WebElement password= driver.findElement(By.xpath("//input[@id='password']"));
        actions.click(password).sendKeys(faker.internet().password())

                .sendKeys(Keys.TAB)

                .sendKeys(Keys.TAB).sendKeys("5").sendKeys(Keys.ARROW_RIGHT).sendKeys("July").sendKeys(Keys.ARROW_RIGHT).sendKeys("1975")
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(faker.company().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(faker.country().name()).sendKeys(Keys.TAB)
                .sendKeys(faker.country().capital()).sendKeys(Keys.TAB)
                .sendKeys(faker.country().capital()).sendKeys(Keys.TAB)
                .sendKeys(faker.country().countryCode2()).sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).sendKeys(Keys.TAB).perform();
        bekle(5);
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();

        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Created!']")).isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
        //11. Verify ' Logged in as username' at top
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Logged in as ']")).isDisplayed());
        //12.Click 'Cart' button
        driver.findElement(By.xpath("//*[text()=' Cart']")).click();
        //13. Click 'Proceed To Checkout' button
        driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")).click();
        //14. Verify Address Details and Review Your Order
        Assert.assertTrue(driver.findElement(By.id("address_delivery")).isEnabled());
        WebElement reviewOrder=driver.findElement(By.xpath("(//div[@class='container'])[2]"));
        Assert.assertTrue(reviewOrder.isEnabled());
        //15. Enter description in comment text area and click 'Place Order'
        driver.findElement(By.xpath("//*[@name='message']")).sendKeys("Good quality, Good price");
        driver.findElement(By.xpath("//*[text()='Place Order']")).click();

        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        String isim=faker.name().firstName();
        WebElement name=driver.findElement(By.xpath("//input[@data-qa='name-on-card']"));
        actions.click(name).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB).sendKeys("123456").sendKeys(Keys.TAB)
                .sendKeys("123").sendKeys(Keys.TAB).sendKeys("10").sendKeys(Keys.TAB).sendKeys("2024")
                .sendKeys(Keys.TAB).perform();
        //17. Click 'Pay and Confirm Order' button
        driver.findElement(By.xpath("//button[text()='Pay and Confirm Order']")).click();
        bekle(3);
        //18. Verify success message 'Your order has been placed successfully!'
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='alert-success alert'])[1]")).isEnabled());
        //19. Click 'Delete Account' button
        WebElement deleteAccount=driver.findElement(By.xpath("//i[@class='fa fa-trash-o']"));
        deleteAccount.click();
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Account Deleted!']")).isDisplayed());
        System.out.println("Account Deleted Testi PASSED");

    }
}
