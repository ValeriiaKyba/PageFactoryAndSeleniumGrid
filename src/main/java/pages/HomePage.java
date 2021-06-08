package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='catalog']//a[contains(@href, 'brendy')]")
    private WebElement brandsButton;

    @FindBy(xpath = "//li[@class='catalog']//a[contains(@href, 'kosmecevtika')]")
    private WebElement сosmeceuticalsButton;

    @FindBy(xpath = "//li[@class='dropdown catalog']//a[contains(text(), 'Для лица')]")
    private WebElement forFaceButton;

    @FindBy(xpath = "//div[@class='dropdown-inner']//a[text()='Уход для лица']")
    private WebElement facialCareButton;

    public void clickOnBrandsButton() {
        brandsButton.click();
    }

    public void clickOnCosmeceuticalsButton() {
        сosmeceuticalsButton.click();
    }

    public void clickOnForFaceButton() {
        forFaceButton.click();
    }

    public void clickOnFacialCareButton() {
        facialCareButton.click();
    }

}
