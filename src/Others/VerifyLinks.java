package Others;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLinks {
	
WebDriver driver;
	
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "/Users/ajoshi007c/Documents/Avinash/workspace/Selenium/chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("http://birlainstitute.co.in/");
			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			System.out.println("Total links are: "+ links.size());
			
			for(int i=0; i<links.size(); i++) {
				WebElement element = links.get(i);
				String url = element.getAttribute("href");
				verifylinkURL(url, i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void verifylinkURL(String linkUrl, int i) {
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); 
			connection.setConnectTimeout(3000);
			connection.connect();
			
			if(connection.getResponseCode()==200) {
				System.out.println("link URL# "+ i +" "+ connection.getResponseCode() +" "+ connection.getResponseMessage() +" "+url);
			}
			else if(connection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println("*****ERROR***** link URL# "+ i +" "+ connection.getResponseCode() +" "+  connection.getResponseMessage() +" "+url);
			}
			else if(connection.getResponseCode()!=200) {
				System.out.println("*****ERROR***** link URL# "+ i +" "+ connection.getResponseCode() +" "+  connection.getResponseMessage() +" "+url);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		VerifyLinks links = new VerifyLinks();
		links.invokeBrowser();
	}

}
