package tests.automationExcercisesPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P06 extends TestBase {
    @Test
    public void test01(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement hp=driver.findElement(By.xpath("//section[@id='slider']"));
        Assert.assertTrue(hp.isDisplayed());
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//i[@class='fa fa-envelope']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        WebElement git=driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        Assert.assertTrue(git.isDisplayed());
        //6. Enter name, email, subject and message
        driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("elif");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("abc@yahoo.com");
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Rooster");
        driver.findElement(By.xpath("//textarea[@placeholder='Your Message Here']")).sendKeys("The rooster is attached");
        //7. Upload file
        WebElement chooseFileButton=driver.findElement(By.xpath("//input[@name='upload_file']"));
        String filePath=System.getProperty("user.home")+"\\Desktop\\T116 Haftalik Ders Programi.pdf";
        chooseFileButton.sendKeys(filePath);
        bekle(3);
        //8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@value='Submit']")).submit();
        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement text=driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        Assert.assertTrue(text.isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        WebElement homeButton=driver.findElement(By.xpath("//a[@class='btn btn-success']"));
        homeButton.click();
        Assert.assertTrue(homeButton.isEnabled());

    }
}
