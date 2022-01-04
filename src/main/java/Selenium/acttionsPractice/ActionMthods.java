package Selenium.acttionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionMthods {

    @Test
    public void test() {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        WebElement searchBox = driver.findElement(By.name("q"));
        Actions actions = new Actions(driver);
        actions.moveToElement(searchBox)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .doubleClick()
                .keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.ARROW_RIGHT)
                .keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.ENTER)
                .perform();

    }

    @Test
    public void test2() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        driver.manage().window().maximize();
//        JavascriptExecutor executor = (JavascriptExecutor)driver;
//        executor.executeScript("document.body.style.zoom = '0.8'");

        WebElement circle = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement blueBox = driver.findElement(By.className("test1"));

        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
actions.clickAndHold(circle).moveToElement(blueBox).release().perform();

    }
}
