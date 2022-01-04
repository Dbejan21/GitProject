package Selenium.Iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFrame {
    @Test
    public void nestedFrameValidation() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0); // switched to top frame
        WebElement middleFrame = driver.findElement(By.name("frame-middle"));
        driver.switchTo().frame(middleFrame); // frame middle
        WebElement middleText = driver.findElement(By.id("content"));
        String actualText = middleText.getText();
        String expected = "MIDDLE";
        Assert.assertEquals(actualText, expected);

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom"); // NoSuchFrameException because it should first exit from middle frame to Parent/HTML
        WebElement bottom = driver.findElement(By.tagName("body"));
        Assert.assertEquals(bottom.getText().trim(), "BOTTOM");

        driver.close();
    }

    @Test
    public void printRightandLeft() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0);
        WebElement rightFrame = driver.findElement(By.name("frame-right"));
        rightFrame.getText().trim();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.switchTo().frame("frame-left");
        WebElement leftText = driver.findElement(By.tagName("body"));
        System.out.println(leftText.getText().trim());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightText = driver.findElement(By.tagName("body"));
        System.out.println(rightText.getText().trim());
    }
}
