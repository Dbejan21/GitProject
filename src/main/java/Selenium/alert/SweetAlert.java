package Selenium.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

public class SweetAlert {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("it will run anotation before each test anotation");
        driver.get("https://sweetalert.js.org/");

    }

    @Test
    public void sweetAlert() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebElement swal = driver.findElement(By.xpath("//button[contains(@onclick, 'swal')]"));
        swal.click();
        Thread.sleep(1000);
        WebElement popMessage = driver.findElement(By.xpath("//div[@class='swal-text']"));
        String actualMessage = BrowserUtils.getText(popMessage);
        softAssert.assertEquals(actualMessage, "Something went wrong!");

        WebElement okButton = driver.findElement(By.xpath("//button[.='OK']"));
        okButton.click();
        Thread.sleep(1000);
        softAssert.assertFalse(okButton.isDisplayed());
        softAssert.assertAll();
    }

    @Test

    public void jsAlert() throws InterruptedException {

        WebElement preview = driver.findElement(By.xpath("//button[contains(@onclick, 'alert')]"));
        preview.click();
        Thread.sleep(1000);
        Alert alert1 = driver.switchTo().alert(); // we confertetd to alert
        alert1.accept();


    }

    @AfterMethod
    public void tearDown() {
        System.out.println("will run anotation After each test anotation");
        driver.quit();
    }


}

