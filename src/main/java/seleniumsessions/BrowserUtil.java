package seleniumsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	public WebDriver driver;
	//Cross Browser
	
	public WebDriver LaunchBrowser(String BrowserName) {
		
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		if(BrowserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		if(BrowserName.equalsIgnoreCase("opera")) {
			WebDriverManager.operadriver().setup();
			driver= new OperaDriver();
		}	
		return driver;
	}
	
public void LauchUrl(String Url) {
	driver.get(Url);
}
public String getPageTittle() {
	return driver.getTitle();
}
public String getPageUrl() {
	return driver.getCurrentUrl();
}
public void quitBrowser() {
	driver.quit();
}
public void closeBrowser() {
	driver.close();
}
}
