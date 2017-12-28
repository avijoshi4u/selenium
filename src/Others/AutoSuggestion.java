package Others;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestion {
	WebDriver driver;
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			
			//System.setProperty("webdriver.firefox.driver", "geckodriver");
			//driver = new FirefoxDriver();
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			//Mousehover();
			RightClick();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Mousehover() {
		try {
			driver.get("https://www.amazon.com/");
			// Type something on job search text box
			driver.findElement(By.xpath("//INPUT[@id='twotabsearchtextbox']")).sendKeys("smart");
			// Create object on Actions class
			Actions action = new Actions(driver);
			// find the element which we want to Select from auto suggestion
			WebElement element = driver.findElement(By.xpath("//DIV[@id='issDiv6']"));
			// use Mouse hover action for that element
			action.moveToElement(element).build().perform();
			
			// Give wait for 2 seconds
			Thread.sleep(2000);
			
			// finally click on that element
			action.click(element).build().perform();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void RightClick() {
		try {
			driver.get("https://www.google.com/");
			Actions act = new Actions(driver);
			WebElement ele = driver.findElement(By.linkText("Images"));
			act.contextClick(ele).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);
			act.build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			AutoSuggestion suggestion = new AutoSuggestion();
			suggestion.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
