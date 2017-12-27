package Others;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogsDemo {
	
WebDriver driver;
	
	public void invokeBrowser() {
		try {
			
			Logger logger = Logger.getLogger("LogsDemo");
			PropertyConfigurator.configure("Log4j.properties");
			
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("http://birlainstitute.co.in/");
			logger.info("Application Launched");
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("scroll(0,2000)");
			logger.info("Scrolled Down");
			
			driver.findElement(By.xpath("//A[@href='http://birlainstitute.co.in/admission/'][text()='Admissions']")).click();
			logger.info("Navigated to the Admission page");
			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			LogsDemo demo = new LogsDemo();
			demo.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
