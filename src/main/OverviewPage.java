package main;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class OverviewPage extends BasePage {

	public OverviewPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(driver, this);
	}
   
	   @FindBy(id = "com.example.challenge:id/recyclerview")
	   public WebElement ProductOverview;
	   
	   public List<WebElement> getProductList(){
		   return ProductOverview.findElements(By.className("android.view.ViewGroup"));	   
	   };
	   
	   public String getProductNameFromProduct(WebElement p) {	   
		   return p.findElement(By.id("com.example.challenge:id/productName")).getText();
	   };
	   
	   public String getPriceFromProduct(WebElement p) {	   
		   return p.findElement(By.id("com.example.challenge:id/productPrice")).getText();
	   };
	   
	   public WebElement getImagefromProduct(WebElement p) {	   
		   return p.findElement(By.id("com.example.challenge:id/productImage"));
	   };
	   
	   public void selectProductByIndex(int i) {
		   getProductList().get(i).click();	   
	   };
	   
	   public void selectProductByName(String name) {
		   int count = getProductList().size();
		   System.out.println(count);
		   for (int i=0; i<count;i++) {
			   String text = ProductOverview.findElements(By.id("com.example.challenge:id/productName")).get(i).getText();
			   System.out.println(text);
			   if (text.equalsIgnoreCase(name)) {
				   getProductList().get(i).click();
				   break;
			   }		   
		   }
	   };
	   	   
}
