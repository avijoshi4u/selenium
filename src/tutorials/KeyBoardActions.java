package tutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;

public class KeyBoardActions {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			//sendKeys();
			pressKey();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendKeys() {
		
		driver.get("https://www.ebay.com/");
		driver.findElement(By.id("gh-ac")).sendKeys("smart watch");
		driver.findElement(By.id("gh-btn")).click();
	}
	
	public void pressKey() {
		driver.get("https://www.ebay.com/");
		
	}

	public static void main(String[] args) {
		try {
			KeyBoardActions actions = new KeyBoardActions();
			actions.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
