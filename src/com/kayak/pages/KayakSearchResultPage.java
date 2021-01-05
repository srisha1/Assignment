package com.kayak.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kayak.base.*;
import com.kayak.utility.KayakReusableFunctions;
import com.relevantcodes.extentreports.LogStatus;

public class KayakSearchResultPage extends KayakBase {
	WebDriver driver;
	
	KayakReusableFunctions functions = new KayakReusableFunctions();
	
	public KayakSearchResultPage(WebDriver driver) throws IOException {		
		// This initElements method will create all WebElements
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public KayakSearchResultPage() {
		// TODO Auto-generated constructor stub
	}
	
	public String titleOfSearchPage() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getTitle();
	}
	
	//to find nth element
	@FindBy(xpath="//div[@class='resultWrapper']")
	List<WebElement> nElements;
	WebElement nthElement;
	
	public void clickNthNumber(String N) throws InterruptedException {
		
		int index=Integer.parseInt(N);
		index = index-1;
		nthElement=	nElements.get(index);
		index = index+1;
		nthElement.click();
		logger.log(LogStatus.PASS, "Element No: "+index + " is clicked successfully");
		//functions.Click(nthElement, "Element No: "+index);

	}
	
	public String resultFromSelected() {
		
		List<WebElement> result= nthElement.findElements(By.xpath("//div[@class='section duration allow-multi-modal-icons']//div[@class='bottom']"));
		logger.log(LogStatus.INFO, "Getting Origin and Destination city codes");
		return result.get(0).getText();//.//span[@class='origin-destination']
		
	}
	
	
	
}


