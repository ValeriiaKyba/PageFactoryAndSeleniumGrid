package storetests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.CapabilityFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
    private CapabilityFactory capabilityFactory = new CapabilityFactory();

    private static final String KRASOTA_SHOP_URL = "https://krasotashop.com/";

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        driver.set(new RemoteWebDriver(new URL("http://192.168.43.59:4444/wd/hub"), capabilityFactory.getCapabilities(browser)));
        getDriver().manage().window().maximize();
        getDriver().get(KRASOTA_SHOP_URL);
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }

    @AfterClass
    void terminate() {
        driver.remove();
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public BrandsPage getBrandsPage() {
        return new BrandsPage(getDriver());
    }

    public SortingResultsPage getSortingResultsPage() {
        return new SortingResultsPage(getDriver());
    }

    public CosmeceuticalsPage getCosmeceuticalsPage() {
        return new CosmeceuticalsPage(getDriver());
    }

    public FacialCarePage getFacialCarePage() {
        return new FacialCarePage(getDriver());
    }

    public LimitingResultsPage getLimitingResultsPage() {
        return new LimitingResultsPage(getDriver());
    }
}
