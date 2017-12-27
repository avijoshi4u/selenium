package tutorials;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllLinks {

	WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
			
			driver.get("https://www.ndtv.com/");
			Links();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void Links() {
		try {
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total links in the page is "+links.size());
			
			for (int i=0; i<links.size(); i=i+1) {
				System.out.println("Number of link # "+i+" "+links.get(i).getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		try {
			FindAllLinks links = new FindAllLinks();
			links.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
