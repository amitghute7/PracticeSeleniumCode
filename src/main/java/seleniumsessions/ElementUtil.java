package seleniumsessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public void doSendKeys(By locator,String locatorValue) {
		getElement(locator).sendKeys(locatorValue);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}

	public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public Boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public Boolean doIsEnabled(By locator) {
		return getElement(locator).isEnabled();
	}
	
	
public List<String> getElementLinksText(By locator) {
	
	List<WebElement> eleList=getElements(locator);
	List<String> eleTextlist=new ArrayList<String>();
	
	for(WebElement e:eleList) {
		String text=e.getText();
		if(!text.isEmpty()) {
			eleTextlist.add(text);
		//	System.out.println(text);
		}	
	}
	return eleTextlist;
}
	

	public List<String> getElementAttributeList(By locator , String AttrName) {
		List<WebElement> eleList=getElements(locator);
		List<String> eleAttrlist= new ArrayList<String>();

		for(WebElement e : eleList) {
			String attrVal=e.getAttribute(AttrName);
			System.out.println(attrVal);
			eleAttrlist.add(attrVal);
		}
		return eleAttrlist;
	}
	
	//*******************************************DropDown Utility*****************************************************
	
	public  void doSelectByVisibleText(By locator,String text) {
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
	
	public  List<String> doGetDropDownOptions(By locator) {
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
	
	public  void doGetDropDownValue(By locator,String value) {
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
	
	public  void doGetSugglistValue(By locator,String value) {
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






