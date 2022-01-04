package Selenium.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;

public class AlertIntro {
    @Test
    public void jsBasicAlertTest(){

      /*  WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsAlert = driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]"));
        jsAlert.click();

        Alert alert =driver.switchTo().alert();
        String jsText = alert.getText();
        Assert.assertEquals(jsText, "I am a JS Alert");
        alert.accept();

        WebElement result= driver.findElement(By.id("result"));
        String resultText = result.getText().trim();
        Assert.assertEquals(resultText,"You successfully clicked an alert");*/

        System.out.println(Math.random());
        System.out.println(Math.nextUp(10.22));
        System.out.println(Math.floor(10.99));
        System.out.println(Math.round(10.55));
        System.out.println(Math.nextAfter(10.22,0.11));


    }
}
