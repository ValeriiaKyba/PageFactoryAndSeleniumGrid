package storetests;

import com.google.common.collect.Ordering;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest{

    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_ADDING = "1";
    private static final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_DELETING = "0";
    private static final long TIME_TO_WAIT = 30;
    private static final int EXPECTED_SIZE_OF_LIST_OF_PRODUCTS_AFTER_LIMITING = 30;

    private static boolean isSorted(List<Integer> pricesOfBrands) {
        return Ordering.<Integer> natural().isOrdered(pricesOfBrands);
    }

    @Test
    public void checkSortingOfBrandsByPriceInASCOrder() {
        getHomePage().clickOnBrandsButton();
        getBrandsPage().clickOnSortingInput();
        getBrandsPage().clickOnPriceASCButton();
        ArrayList<Integer> integerPricesOfBrands = getSortingResultsPage().convertPricesIntoIntegerAndAddToIntegerArray();
        assertTrue(isSorted(integerPricesOfBrands));
    }

    @Test
    public void checkDeleteFromCartAfterAddingProduct() {
        getHomePage().clickOnCosmeceuticalsButton();
        getCosmeceuticalsPage().hoverOnCosmeceuticalProduct();
        getCosmeceuticalsPage().clickOnBuyButton();
        getCosmeceuticalsPage().waitForAjaxToComplete(TIME_TO_WAIT);
        getCosmeceuticalsPage().clickOnCloseSuccessMessageOfAdding();
        assertEquals(getCosmeceuticalsPage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_ADDING);
        getCosmeceuticalsPage().clickOnCart();
        getCosmeceuticalsPage().clickOnDeleteFromCart();
        getCosmeceuticalsPage().waitForAjaxToComplete(TIME_TO_WAIT);
        assertEquals(getCosmeceuticalsPage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART_AFTER_DELETING);
    }

    @Test
    public void checkThatAmountOfProductsOnPageMatchesChosen30() {
        getHomePage().clickOnForFaceButton();
        getHomePage().clickOnFacialCareButton();
        getFacialCarePage().clickOnLimitOfProductsInput();
        getFacialCarePage().clickOnLimit30Button();
        assertEquals(getLimitingResultsPage().getSizeOfListOfProducts(), EXPECTED_SIZE_OF_LIST_OF_PRODUCTS_AFTER_LIMITING);
    }
}
