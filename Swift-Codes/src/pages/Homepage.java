package pages;

//Project Imports
import repos.HomePageRepo;
import properties.Properties;


//Java Imports
import java.util.List;
import util.Util;
import java.util.HashMap;
import java.util.LinkedHashMap;

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



public class Homepage {
	static WebDriver driver;
	static WebDriverWait wait;
	
	@Test
	public void Get_BankDetails() {
		
		//Making list of all the bank names
		List<WebElement> list = driver.findElements(By.xpath(HomePageRepo.bankName));
		
		//Initializing a map of bank names and SWIFT codes
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();

		
		//Getting the bank names and swift codes in map
		map = Util.Get_BankList(list, map, driver);
		
		//Iterating the map to print on console
		for (HashMap.Entry<String, String> entry : map.entrySet()) {
		    System.out.println(entry.getKey()+" : "+entry.getValue());
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
