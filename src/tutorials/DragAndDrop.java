package tutorials;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("http://keenthemes.com/preview/metronic/theme/admin_1/ui_tree.html");
			DDOperation();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void DDOperation() {
		//moving 'Disabled Node' from 'Parent Node' folder to 'Initially Selected' folder
		try {
			WebElement From = driver.findElement(By.xpath("//A[@id='j3_7_anchor']"));
			WebElement To = driver.findElement(By.xpath("//A[@id='j3_2_anchor']"));
			
			Actions builder = new Actions(driver);
			
			Action dragAndDrop = builder.clickAndHold(From).moveToElement(To).release(To).build();
			
			dragAndDrop.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			DragAndDrop dd = new DragAndDrop();
			dd.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
