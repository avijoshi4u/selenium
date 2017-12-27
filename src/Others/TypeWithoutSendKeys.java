package Others;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;;

public class TypeWithoutSendKeys {

	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("http://opensource.demo.orangehrmlive.com/");
			fillText();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//How to type in Selenium without using sendKeys() method
	public void fillText() {
		try {
			//Execute JavaScript in your script
			((JavascriptExecutor)driver).executeScript ("document.getElementById('txtUsername').value='Admin';");
			((JavascriptExecutor)driver).executeScript ("document.getElementById('txtPassword').value='admin';");
			
			((JavascriptExecutor)driver).executeScript ("document.getElementById('btnLogin').click();");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		TypeWithoutSendKeys keyObject = new TypeWithoutSendKeys();
		keyObject.invokeBrowser();
	}

}
