package seleniumsessions;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionList {

	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException {

		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.google.com/");
		 driver.findElement(By.name("q")).sendKeys("Naveen Automation Labs");
		 Thread.sleep(3000);
		 By sugglist= By.xpath("//div[@role='option']//div[@class='wM6W7d']//span");
		 doGetSugglistValue(sugglist, "naveen automation labs api testing");
//		 List<WebElement> sugglist = driver.findElements(By.xpath("//div[@role='option']//div[@class='wM6W7d']//span"));
//		 System.out.println(sugglist.size());
//		 for(WebElement e : sugglist) {
//			 String text = e.getText();
//			 System.out.println(text);
//		 }	 
	}
	
	 public static List<WebElement> getElements(By locator) {
			return driver.findElements(locator);
		}

	 
public static  void doGetSugglistValue(By locator,String value) {
	List<WebElement> sugglist =getElements(locator);
	System.out.println(sugglist.size());
	 for(WebElement e : sugglist) {
		 String text = e.getText();
		 System.out.println(text);
		 if(text.equals(value)) {
			 e.click();
			 break;
		 }
	 }	 
}
}
