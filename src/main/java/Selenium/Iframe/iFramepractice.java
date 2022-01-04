package Selenium.Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iFramepractice {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement inputBox = driver.findElement(By.id("tinymce"));
        inputBox.clear();
        inputBox.sendKeys("Hello Diana");
        driver.switchTo().parentFrame();
        WebElement title = driver.findElement(By.tagName("h3"));
        String actualTitle = title.getText().trim();
        String expectedTitle = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualTitle, expectedTitle);

    }
}