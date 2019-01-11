package util;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import repos.HomePageRepo;

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
	
	public static LinkedHashMap<String, String> Get_BankList(List<WebElement> list,LinkedHashMap<String,String> map, WebDriver driver){
		
		for (int i=0;i<list.size();i++) {
			String temp, temp1;
			
			//Storing the name of the bank as - 'Bank Name, City, Branch(if available)
			if(!driver.findElement(By.xpath("("+HomePageRepo.bankName+")["+ (i+1) +"]/following-sibling::td[2]")).getText().isEmpty()) {
				temp = i+1 + " - " + list.get(i).getText() +", "
						+ driver.findElement(By.xpath("("+HomePageRepo.bankName+")["+ (i+1) +"]/following-sibling::td[1]")).getText() + ", " 
						+ driver.findElement(By.xpath("("+HomePageRepo.bankName+")["+ (i+1) +"]/following-sibling::td[2]")).getText();
			} else {
				temp = i+1 + " - " + list.get(i).getText() +", "
						+ driver.findElement(By.xpath("("+HomePageRepo.bankName+")["+ (i+1) +"]/following-sibling::td[1]")).getText();	
			}
			temp1 = driver.findElement(By.xpath("("+HomePageRepo.bankName+")["+ (i+1) +"]/following-sibling::td[3]/a")).getText();
			
			//Inserting them in map
			map.put(temp, temp1);
			}

		
		return map;		
	}

}
