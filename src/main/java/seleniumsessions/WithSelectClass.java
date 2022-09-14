package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WithSelectClass {
	static WebDriver driver;
	public static void main(String[] args) {

		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/?");
		 
//		 WebElement country = driver.findElement(By.name("Country"));
//		 Select select = new Select(country);
//		 select.selectByVisibleText("India");
//		 select.selectByIndex(5);
//		 select.selectByValue("Austria");
		By country= By.name("Country");
//		doSelectByVisibleText(country, "India");
	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSelectByVisibleText(By locator,String text) {
		Select select =new Select(getElement(locator));
		select.selectByVisibleText(text);
		
	}
	
	public void doSelectByIndex(By locator,int index) {
		Select select =new Select(getElement(locator));
		select.selectByIndex(index);
		
	}
	
	public void doSelectByValue(By locator,String value) {
		Select select =new Select(getElement(locator));
		select.selectByValue(value);
		
	}
	
	
	
	

}
