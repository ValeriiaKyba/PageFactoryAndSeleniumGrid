package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CosmeceuticalsPage extends BasePage{

    public CosmeceuticalsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[contains(@class, 'product-grid')]")
    private List<WebElement> listOfCosmeceuticalProducts;

    @FindBy(xpath = "//button[text()='Купить']")
    private List<WebElement> listOfBuyButtons;

    @FindBy(xpath = "//div[@id='cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//span[@id='cart-total']")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//button[contains(@class, 'btn-danger')]")
    private WebElement deleteFromCartButton;

    @FindBy(xpath = "//button[@class='close']")
    private WebElement closeSuccessMessageOfAdding;

    public void hoverOnCosmeceuticalProduct() {
        Actions builder = new Actions(driver);
        builder.moveToElement(listOfCosmeceuticalProducts.get(0)).perform();
    }

    public void clickOnBuyButton() {
        listOfBuyButtons.get(0).click();
    }

    public void clickOnCart() {
        cartButton.click();
    }

    public String getTextOfAmountProductsInCart() {
        return amountOfProductsInCart.getText();
    }

    public void clickOnDeleteFromCart() {
        deleteFromCartButton.click();
    }

    public void clickOnCloseSuccessMessageOfAdding() {
        closeSuccessMessageOfAdding.click();
    }

}
