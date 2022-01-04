package Selenium.acttionsPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.List;

public class DoubleClickPrc {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml?jfwid=1382a");
        WebElement blind = driver.findElement(By.id("blind_header"));

        List<WebElement> buttons= driver.findElements(By.xpath("//div[contains(text(),'click')]"));

        Actions actions= new Actions(driver);
        for (WebElement button:buttons)
              { if (BrowserUtils.getText(button).equals("click")){
                  button.click();
              } else {
                  actions.doubleClick(button).perform();
              }

        }
    }
}