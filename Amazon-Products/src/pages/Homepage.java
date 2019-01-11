package pages;

//Project Imports
import repos.HomePageRepo;
import util.Util;

//Java Imports
import java.util.List;

//Selenium Imports
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TestNG Imports
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import properties.Properties;



public class Homepage {
	static WebDriver driver;
	static WebDriverWait wait;
	
	@Test
	public void Get_ProductImages() {
		
		//Making list of all the product images
		List<WebElement> list = driver.findElements(By.xpath(HomePageRepo.images));
		
		//Iterating the list
		for (WebElement webElement : list) {
			System.out.println(webElement.getAttribute("href"));
		}
	}
	
	@BeforeTest
	public void setup() {
		//Setting up the WebDriver
		driver = Util.Setup_WebDriver(driver);
		
		//Setting up the WebDriverWait
		wait = Util.Setup_WebDriverWait(driver, wait);
		
		//Open the url
		driver.get(Properties.URL);
		
		//waiting for the application to open
		wait.until(ExpectedConditions.titleContains(Properties.title));				
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
		
}
