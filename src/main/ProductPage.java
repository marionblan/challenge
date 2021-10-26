package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductPage extends BasePage{
	
	public ProductPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	   @FindBy(id = "com.example.challenge:id/productName")
	   public WebElement ProductName;
	   
	   @FindBy(id = "com.example.challenge:id/productPrice")
	   public WebElement ProductPrice;
	   
	   @FindBy(id = "com.example.challenge:id/productImage")
	   public WebElement ProductImage;
	   
	   @FindBy(id = "com.example.challenge:id/addReview")
	   public WebElement ReviewButton;
	
}
