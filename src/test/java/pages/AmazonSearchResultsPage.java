package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonSearchResultsPage {

    public AmazonSearchResultsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(tagName = "a")
   private List<WebElement> resultLinks;
    public int getResultCount(){
        return resultLinks.size();

    }

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    private WebElement resultText;

    public int getValidateSearchResult() {
        String[] resultsArr = resultText.getText().split(" ");
        String resultsNum = resultsArr[3].replace(",", "");
        int results = Integer.parseInt(resultsNum);
        return results;
    }
}