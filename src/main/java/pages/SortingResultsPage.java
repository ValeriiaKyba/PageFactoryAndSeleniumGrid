package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SortingResultsPage extends BasePage{

    public SortingResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='price']")
    private List<WebElement> pricesOfSortedBrands;

    public ArrayList<Integer> convertPricesIntoIntegerAndAddToIntegerArray() {
        ArrayList<Integer> prices = new ArrayList<>();
        for (WebElement price : pricesOfSortedBrands) {
            prices.add(Integer.parseInt(price.getText().replace(" грн", "")));
        }
        return prices;
    }
}
