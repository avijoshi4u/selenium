package tutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriverdemo {

	WebDriver driver;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("http://www.calculator.net/");
			
			mathOperations();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void mathOperations() {
		try {
			driver.findElement(By.xpath("//*[contains(text(),'Math Calculators')]")).click();
			driver.findElement(By.xpath("//*[@id='content']/ul/li[3]/a")).click();
			driver.findElement(By.id("cpar1")).sendKeys("10");
			driver.findElement(By.id("cpar2")).sendKeys("50");
			driver.findElement(By.xpath("//input[@value='Calculate']")).click();
			
			String result = driver.findElement(By.xpath("//h2[@class='h2result']")).getText();
			
			System.out.println(result);
			
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		try {
			webdriverdemo demo = new webdriverdemo();
			demo.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
