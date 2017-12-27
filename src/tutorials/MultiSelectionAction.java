package tutorials;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiSelectionAction {
	
	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.drvier","chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("https://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx");
			Actions();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Actions() {
		try {
			
			WebElement select = driver.findElement(By.id("ContentHolder_lbFeatures_LBT"));
			List<WebElement> options = select.findElements(By.tagName("tr"));
			System.out.println("Available options "+options.size());
			
			Actions builder = new Actions(driver);
			Action multipleSelect = builder.keyDown(Keys.CONTROL).click(options.get(1).click();).build();
			multipleSelect.perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			MultiSelectionAction action = new MultiSelectionAction();
			action.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
