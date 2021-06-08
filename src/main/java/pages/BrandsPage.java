package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandsPage extends BasePage{

    public BrandsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'input-sort')]")
    private WebElement sortingInput;

    @FindBy(xpath = "//div[@class='select input-sort']//li[contains(@rel, 'price') and contains(@rel, 'ASC')]")
    private WebElement priceASCButton;

    public void clickOnSortingInput() {
        sortingInput.click();
    }

    public void clickOnPriceASCButton() {
        priceASCButton.click();
    }
}
