package tests.automationExcercisesPractice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class P01 extends TestBase {
    @Test
    public void test01(){
        driver.get("https://automationexercise.com");
        WebElement signUpElementi= driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
        Actions actions=new Actions(driver);
        actions.click(signUpElementi).perform();
        WebElement name= driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        name.sendKeys("Elif");
        WebElement email=driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys("sele@hotmail.com");
        driver.findElement(By.xpath("//button[text()='Signup']")).click();
        WebElement title=driver.findElement(By.xpath("//input[@value='Mrs']"));
        actions.click(title).perform();

        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("12345678");


        WebElement dateOfBirth=driver.findElement(By.xpath("//select[@id='days']"));
        dateOfBirth.sendKeys("21");
        WebElement month=driver.findElement(By.xpath("//select[@id='months']"));
        Select select=new Select(month);
        select.selectByIndex(10);
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1984");

        bekle(3);
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        bekle(3);
        WebElement firstName=driver.findElement(By.xpath("//input[@id='first_name']"));
        firstName.sendKeys("Elif");

        WebElement lastName= driver.findElement(By.xpath("//input[@id='last_name']"));
        lastName.sendKeys("Sertkaya");
        WebElement company= driver.findElement(By.xpath("//input[@id='company']"));
        company.sendKeys("Wise Quarter");

        bekle(3);
        WebElement adres1= driver.findElement(By.xpath("//input[@id='address1']"));
        adres1.sendKeys("Johann Sebastian");

        WebElement adres2=driver.findElement(By.xpath("//input[@id='address2']"));
        adres2.sendKeys("Bachstraat");

        WebElement selection=driver.findElement(By.xpath("//select[@id='country']"));
        Select select1=new Select(selection);
        select.selectByIndex(1);

        WebElement state= driver.findElement(By.xpath("//input[@id='state']"));
        state.sendKeys("Arizona");
        bekle(2);

        WebElement city= driver.findElement(By.xpath("//input[@id='city']"));
        city.sendKeys("Rotterdam");
        bekle(2);

        bekle(3);
        driver.findElement(By.xpath("//input[@id='zipcode']")).sendKeys("2983AA");
        bekle(2);
        driver.findElement(By.xpath("//input[@id='mobile_number']")).sendKeys("123456789");
        bekle(2);
        WebElement createAccount=driver.findElement(By.xpath("//button[text()='Create Account']"));
        createAccount.click();
        WebElement text=driver.findElement(By.xpath("//b[text()='Account Created!']"));
        String expectedText="ACCOUNT CREATED!";
        String actualText=text.getText();
        Assert.assertEquals(expectedText,actualText);
        System.out.println("Yazi testi PASSED");
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        //16. Verify that 'Logged in as username' is visible
        WebElement logInTesti=driver.findElement(By.xpath("//*[@class='fa fa-user'] "));
        String expText="Logged in as Elif";
        String actText=logInTesti.getText();
        Assert.assertTrue(expText.contains(actText));
        System.out.println("Test PASSED");
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[text()=' Delete Account']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button












    }
}
