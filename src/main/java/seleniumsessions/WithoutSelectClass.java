package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WithoutSelectClass {
	
		static WebDriver driver;
		
		public static void main(String[] args) throws InterruptedException {

			
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
			 
//			 WebElement country = driver.findElement(By.name("Country"));
//			 country.sendKeys("India");
//			 Select select = new Select(country);
//			List<WebElement> countrylist = select.getOptions();
//			System.out.println(countrylist.size());
//			for(WebElement e : countrylist) {
//				String text = e.getText();
//				System.out.println(text);
//	
//			}
			 By Coutrylist = By.name("Country");
//			 doSelectByVisibleText(Coutrylist, "India");
//			 Thread.sleep(3000);
//			 System.out.println(doGetDropDownOptions(Coutrylist).contains("India"));
			 doGetDropDownValue(Coutrylist, "India");
		
	}
			 public static WebElement getElement(By locator) {
					return driver.findElement(locator);
				}

		public static List<String> doGetDropDownOptions(By locator) {
			 Select select = new Select(getElement(locator));
				List<WebElement> countrylist = select.getOptions();
				List<String> Optionslist = new ArrayList<String>();
				System.out.println(countrylist.size());
				for(WebElement e : countrylist) {
					String text = e.getText();
					System.out.println(text);
					Optionslist.add(text);
					
				}
			return Optionslist;

		}
		public static void doSelectByVisibleText(By locator,String text) {
			Select select =new Select(getElement(locator));
			select.selectByVisibleText(text);	
		}
		public static void doGetDropDownValue(By locator,String value) {
			 Select select = new Select(getElement(locator));
				List<WebElement> countrylist = select.getOptions();
				System.out.println(countrylist.size());
				for(WebElement e : countrylist) {
					String text = e.getText();
					if(text.equals(value)) {
						e.click();
						break;
				}
		}
		}
}