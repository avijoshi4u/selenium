package Others;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
	
	WebDriver driver;
	public void invokeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			
			driver.get("https://www.tripadvisor.com/");
			picker();			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void picker() {
		try {
			driver.findElement(By.xpath("//A[@id='global-nav-Flights']")).click();
			driver.findElement(By.xpath("(//INPUT[@type='text'])[3]")).sendKeys("DEL");
			
			driver.findElement(By.xpath("(//INPUT[@type='text'])[4]")).sendKeys("BLR");
			driver.findElement(By.xpath("(//SPAN[@class='ui_icon calendar pickerType'])[1]")).click();
			
			String Date = "7-Jan 2018";
			String splitter[] = Date.split("-");
			String selectDay = splitter[0];
			String seelctMonth_Year = splitter[1];
			
			selectDate(selectDay, seelctMonth_Year);
			
			Date = "13-Mar 2018";
			splitter = Date.split("-");
			selectDay = splitter[0];
			seelctMonth_Year = splitter[1];
			
			selectDate(selectDay, seelctMonth_Year);
			
			System.out.println("I AM HERE "+selectDay+" "+seelctMonth_Year);
			Thread.sleep(3000);
			driver.findElement(By.xpath("(//BUTTON[@class='form_submit searchBtn en_US en'])[1]")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectDate(String Day, String Month_Year) {
		try {
			List <WebElement> months = driver.findElements(By.xpath("//SPAN[@class='dsdc-month-title']"));
			
			for (int i=0; i<months.size(); i++) {
				//Select the month_year
				if (months.get(i).getText().equals(Month_Year)) {
					//Select the date
					List <WebElement> dates = driver.findElements(By.xpath("//SPAN["+i+1+"]/SPAN[@class='dsdc-cell dsdc-day']"));
					for (int j=0; j<dates.size(); j++) {
						if (dates.get(j).getText().equals(Day)) {
							dates.get(j).click();
							return;			
						}
					}
				}
			}
			
			driver.findElement(By.xpath("//DIV[@class='dsdc-next ui_icon single-chevron-right-circle']")).click();
			Thread.sleep(3000);
			System.out.println("WOW "+Day+ Month_Year);
			selectDate(Day, Month_Year);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			DatePicker picker = new DatePicker();
			picker.invokeBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
