package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public abstract class BasePage {
	
	 @FindBy(id = "com.example.challenge:id/toolbar")
	   public WebElement Toolbar;
	 
	 public String getAppName() {		 
		 return Toolbar.findElement(By.className("android.widget.TextView")).getText();
	 }
	 
	   public void scrollToProduct(AndroidDriver<AndroidElement> driver, String name) {
		   driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ name +"\"));");
	   };
}
