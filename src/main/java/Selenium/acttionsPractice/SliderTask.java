package Selenium.acttionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SliderTask {

    @Test

    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get(" https://the-internet.herokuapp.com/horizontal_slider");
        WebElement slider = driver.findElement(By.tagName("input"));
        WebElement text = driver.findElement(By.id("range"));
        navigateToTarget(slider, text, driver, 3.5);

//        Actions actions = new Actions(driver);
//        actions.clickAndHold(slider).moveByOffset(-40,0).perform();
        Point point = slider.getLocation();
        System.out.println(point.getX());
        System.out.println(point.getY());

        // sourse --> target --> find the webelement of the target then
        // using Point class(getLocation() method ), you can provide the x and y coordinate

        ///Task : create the function that takes WebElement ,driver, target number
        // navigateToTarget(slider, driver, target)


    }

    public void navigateToTarget(WebElement slider, WebElement text, WebDriver driver, double targetNum) {

        Actions actions = new Actions(driver);
        if (targetNum == 2.5) {
            actions.clickAndHold(slider).perform();
        } else if (targetNum > 2.5) {
            int count = 10;//3.5
            while (!text.getText().equals(String.valueOf(targetNum))) {
                actions.clickAndHold(slider).moveByOffset(count, 0).perform();
                count += 10;

            }
        } else {
            int count = -10;
            while (!text.getText().equals(String.valueOf(targetNum))) {
                actions.clickAndHold(slider).moveByOffset(count, 0).perform();
                count -= 5;
            }

        }
    }
}
