package tutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Synchronization {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			
			
			waitActions();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitActions() {
		try {
			
			//Thread.sleep: is a static wait, i.e.- sleep without condition (it's not a good way to use is scripts).
			Thread.sleep(10000);
			driver.get("http://birlainstitute.co.in/");
			
			//Explicit Waits: used for a certain condition to occur before proceeding further 
			//(It is mainly used when we want to click or act on an object once it's visible).
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		try {
			Synchronization sync = new Synchronization();
			sync.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
