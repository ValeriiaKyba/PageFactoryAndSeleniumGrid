package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LimitingResultsPage extends BasePage{

    public LimitingResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'product-grid')]")
    private List<WebElement> listOfProducts;

    public int getSizeOfListOfProducts() {
        return listOfProducts.size();
    }
}
