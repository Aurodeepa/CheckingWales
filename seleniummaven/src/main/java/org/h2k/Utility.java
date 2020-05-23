package org.h2k;

import java.util.List;
import java.security.NoSuchAlgorithmException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.NoSuchElementException;


public class Utility {
	
	WebDriver driver;
	int i ;
	public Utility(int i )
	{
		this.i = i;

	}
	public Utility(WebDriver driver) {
		this. driver = driver;
	}
	public int a()
	{

		int i =10;
		return i;
	}
	public List<WebElement> retrieveSearchList(String searchText) throws Exception
	{
		System.out.println(searchText);
		driver.findElement(By.id("header-search-input")).clear();
		driver.findElement(By.id("header-search-input")).sendKeys(searchText);
		Thread.sleep(5000);
		
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//List<WebElement> searchList =wait.until(ExpectedConditions.
				//visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
		List<WebElement> searchList = driver.findElements(By.xpath("//ul[@role='listbox']/li/span"));
		return searchList;
	}
	/**
	 * searchPattern: selenium interview questions
	 * searchText: selenium
	 * 
	 * @param searchPattern
	 * @param searchText
	 * @return
	 * @throws Exception 
	 */
	public boolean selectRequiredSearchPattern(String searchPattern,String searchText) throws Exception
	{
		boolean result = false;
		List<WebElement> searchList = retrieveSearchList(searchText);
		for(int i=0;i<searchList.size();i++) 
		{
			if(searchList.get(i).getText().contains(searchPattern))
			{
				searchList.get(i).click();
				result = true;
				break;
			}
		}
		return result;


	}


	/**
	 * searchPattern : Questions
	 * n : 5 number of pages
	 * title : selenium interview questions
	 * @param searchPattern
	 * @param n
	 * @param title
	 * @return
	 */
	public boolean validateLinkText(String searchPattern, int n,String title )
	{


		boolean result =true; 
		List<WebElement> hLinkList;
		for(int i=1;i<=n;i++)
		{
			hLinkList = driver.findElements(By.xpath("//div[@id='web']/ol/li//a"));	
			System.out.println("****************Validating the Links in the Page ::: " + i+"****************************" );
			for(int j=0;j<hLinkList.size();j++)//HyperLinks Text
			{
				System.out.println(hLinkList.get(j).getText().contains(searchPattern));
				
				
				if(!(hLinkList.get(j).getText().contains(searchPattern)))
				{
					result = false;
					System.out.println(hLinkList.get(j).getText());
					System.out.println("The Link Text " + hLinkList.get(j).getText()  +"   result:::" + result);	 
				}
			}
			clickHyperlink(driver.findElement(By.linkText((i+1)+"")));
			waitforTitle(title);

		}
		return result;
	}
	public void clickHyperlink(WebElement ele)
	{
		ele.click();
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				js.executeScript("arguments[0].click();",ele);
//				js.executeScript("return document.title");
				

	}
	public void waitforTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains(title));
	}
}
