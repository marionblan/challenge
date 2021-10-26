package test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class base {
	public static AndroidDriver<AndroidElement> driverCapabilities() throws MalformedURLException, InterruptedException {
		// Set capabilities
		File appDir = new File("src");
		File app = new File(appDir, "app-debug.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "MarionEmulator");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());	
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, org.openqa.selenium.Platform.ANDROID.name());
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://169.254.80.80:4723/wd/hub"),cap);
		
		return driver;		
	};
}
