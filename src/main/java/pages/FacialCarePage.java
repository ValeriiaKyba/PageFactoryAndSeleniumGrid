package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FacialCarePage extends BasePage{

    public FacialCarePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'input-limit')]")
    private WebElement limitOfProductsInput;

    @FindBy(xpath = "//li[text()='30']")
    private WebElement limit30Button;

    public void clickOnLimitOfProductsInput() {
        limitOfProductsInput.click();
    }

    public void clickOnLimit30Button() {
        limit30Button.click();
    }

}
