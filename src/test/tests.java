package test;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import main.OverviewPage;
import main.ProductPage;
import main.ReviewPage;


public class tests extends base {
	
	public AndroidDriver<AndroidElement> driver;
	public OverviewPage o;
	public ProductPage p;
	public ReviewPage r;
	public List<WebElement> listOfProducts;
	public WebDriverWait wait;
	
	@BeforeMethod
	public void beforeEach() throws MalformedURLException, InterruptedException {
		driver = driverCapabilities();
		o = new OverviewPage(driver);	
		p = new ProductPage(driver);	
		r = new ReviewPage(driver);	
		
		listOfProducts = o.getProductList();
	
		// Wait until first element is displayed to proceed
		wait = new WebDriverWait(driver, 2);
		wait.until(ExpectedConditions.visibilityOf(listOfProducts.get(0)));
	}
	
	@Test(description = "TC01 Verify that product details are displayed on the product overview page.")
	public void VerifyProductDetailsDisplayed() throws MalformedURLException, InterruptedException {
		// Make sure all fields are displayed and not empty for the visible products
		for (WebElement p : listOfProducts) {
			int index = listOfProducts.indexOf(p);
			Assert.assertTrue(o.getImagefromProduct(p).isDisplayed(), "The image for product " + index + " is not displayed.");
			Assert.assertTrue(!o.getPriceFromProduct(p).isEmpty(), "The price for product " + index + " is empty.");
			Assert.assertTrue(!o.getProductNameFromProduct(p).isEmpty(), "The name for product " + index + " is empty.");
		}	
	}
	
	@Test(description = "TC02 Verify that product details are displayed after selecting a product.")
	public void ViewAProduct() throws MalformedURLException, InterruptedException {
		// First store second product details then select it
		String oProductName = o.getProductNameFromProduct(listOfProducts.get(1));
		String oProductPrice = o.getPriceFromProduct(listOfProducts.get(1));
		o.selectProductByIndex(1);
			
		// Verify same details are also displayed on the product page
		String pProductName = p.ProductName.getText();
		String pProductPrice = p.ProductPrice.getText();
		Assert.assertEquals(pProductName, oProductName, "The product name on the product page is not the same as on the product overview");
		Assert.assertEquals(pProductPrice, oProductPrice, "The product price on the product page is not the same as on the product overview");
		Assert.assertTrue(p.ProductImage.isDisplayed(), "The image of the product is not displayed on its page");
	
		// Verify that the Review button is enabled
		Assert.assertTrue(p.ReviewButton.isEnabled(), "The Add review button is not enabled on the product page.");
	}
	
	@Test(description = "TC03 Verify that a new screen opens to add a review.")
	public void OpenReviewPage() {	
		// Select a product
		o.selectProductByIndex(0);
	
		// Open Review screen - Make sure new fields are present (further tests out of scope)
		p.ReviewButton.click();
	
		Assert.assertTrue(r.ReviewInput.isDisplayed(), "The review input field is not displayed");
		Assert.assertTrue(r.ReviewNumberSpinner.isDisplayed(), "The spinner to choose review mark is not displayed");
		Assert.assertTrue(r.SaveButton.isDisplayed(), "The Save button is not displayed");
	};
	
	@Test(description = "TC04 Verify that the Application name is displayed throughout the flow.")
	public void VerifyApplicationName() {
		String AppName = "Challenge";
		
		// From Overview page
		Assert.assertEquals(o.getAppName(),AppName, "The Application name on Product Overview is not Challenge");
		
		// Go to Product page
		o.selectProductByIndex(2);
		Assert.assertEquals(p.getAppName(),AppName, "The Application name on Product View is not Challenge");
		
		// Open Review screen
		p.ReviewButton.click();
		Assert.assertEquals(r.getAppName(),AppName, "The Application name on Product Review is not Challenge");
	};
	
	// I was working on this test when the app stopped working (reason unknown) so I couldn't finish testing it
	// If the scroll and select methods worked I would have updated the other tests with them as well, instead of the selectProductByIndex
	@Test(description = "TC05 Verify that the user can navigate between pages.")
	public void VerifyNavigationBetweenPages() {
		String productName = "Wan Show";
		// Scroll to product and select it
		o.scrollToProduct(driver, productName);	
		o.selectProductByName(productName);
		
		// Go back to overview + Make sure the selected product is still visible (not back to top)
		
		// Select another product and verify data is for this new product
		
		// Go until Review page
		
		// Go back to Product page
		
		// Go back to Overview + Make sure the selected product is still visible (not back to top)

	};
	

	@AfterMethod
	public void afterEach() {	
		driver.quit();
	};
}
