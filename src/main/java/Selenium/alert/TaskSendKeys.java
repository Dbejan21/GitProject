package Selenium.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskSendKeys {


    @Test
    public void test() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='Click for JS Prompt']"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();

        alert.sendKeys("Techtorial");
        WebElement resultText = driver.findElement(By.id("result"));
        String actual = resultText.getText().trim();
        Assert.assertEquals(actual, "You entered: Techtorial");


    }
}