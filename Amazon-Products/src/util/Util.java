package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {
	
	public static WebDriver Setup_WebDriver(WebDriver driver) {
		//Setting properties for Chrome browser 
		System.setProperty("webdriver.chrome.driver", "src/Files/chromedriver.exe");
		//Initialize the WebDriver
		driver = new ChromeDriver();
		// maximize the browser window
		driver.manage().window().maximize();
		//Adding Implicit waits
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;				
	}
	
	public static WebDriverWait Setup_WebDriverWait(WebDriver driver, WebDriverWait wait) {		
		//Initialize waits
		wait = new WebDriverWait(driver, 30);		
		return wait;
	}

}
