package seleniumsessions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverConcept  {
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--Incognito");
//		co.addArguments("--Headless");

		WebDriver driver = new ChromeDriver(co);
        driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.get("https://www.Amazon.com/");
		

		System.out.println(driver.getTitle());
		driver.close();

	}

	
	
	public void cartPage() {
		System.out.println("this is my photo");
	}
	
	
	
	
	
	public void getScreenshot(){
		TakesScreenshot srcshotfile = ((TakesScreenshot) driver);
		File srcfile = srcshotfile.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/Screenshot/" + System.currentTimeMillis() + ".jpg";
		File destfile = new File(path);
		try {
			FileUtils.copyFile(srcfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
