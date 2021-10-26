package main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ReviewPage extends BasePage {

	public ReviewPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(id = "com.example.challenge:id/reviewNumber")
	   public WebElement ReviewNumberSpinner;
	   
	   @FindBy(id = "com.example.challenge:id/reviewDetails")
	   public WebElement ReviewInput;
	   
	   @FindBy(id = "com.example.challenge:id/saveReview")
	   public WebElement SaveButton;

}
