package com.kayak.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.kayak.base.*;
import com.kayak.utility.KayakReusableFunctions;
import com.relevantcodes.extentreports.LogStatus;

public class KayakHomePage extends KayakBase {
	
	WebDriver driver;
	Robot r;
	
	KayakReusableFunctions functions = new KayakReusableFunctions();
		
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/button[1]")
	WebElement CrossButton;	//To remove default selection SFO
	
	@FindBy(xpath="//input[contains(@id,'-origin-airport')][@type='text'][@placeholder='From?']")
	WebElement FromCityText;
	
	@FindBy(xpath ="//div[@data-placeholder='To?'][@aria-label='Flight destination input']")
	WebElement ToCity;
	
	@FindBy(xpath="//input[contains(@id,'-destination-airport')][@type='text'][@placeholder='To?']")
	WebElement ToCityText;
	
	@FindBy(css ="body.keel.kl.kl-override.FlightsSearch.react.react-st.en_US.horizon:nth-child(2) div.Common-Page-StandardPage.Base-Search-LandingPage.Base-Search-SearchPage.Flights-Search-FlightSearchPage.cur_usd.a11y-focus-outlines.vm-fd:nth-child(1) div.Common-Layout-StandardBody.withFooter main.pageContent.withDrawer:nth-child(6) div.SearchPage__FrontDoor div.Base-Frontdoor-FrontDoor.Flights-Frontdoor-FlightFrontDoor div.Common-Frontdoor-HarmonizedFrontDoorContent div.coverPhotoContainer.splash div._jcP._jcQ._ia2 div.primary-content section.form-section.noBg div.keel-container.form-container.s-t-bp.no-edges.edges-s div.Base-Search-SearchForm.Flights-Search-StyleJamFlightSearchForm.size-xs.size-s.size-m.size-l._iMI._mpe div.js-searchForm:nth-child(2) form.js-rtow.searchform._ijX._iAB.roundtrip div.search-form-inner div.keel-grid._iCe._kP2._iaU._kP3._iAO._iaO._iaP._iaA._iyF._iAN._kP4._j2g div.col._iac._iad._iae._i0p._iaa._i0q._iab._iys._iyv._i5L._iyq._iAV._iA1._h-8._ij0:nth-child(1) div.keel-grid._icA._ica._icB._icb._icC._icc._iyY._iaA._icD._ib9._iy1._iAO._iaO._iaP._iyF._iAN div.col._icy._iaS._iaU._iaV._iaW._iaX._icu._icv._icw._icx._ia0._ics._ict._ize._is9._iaR._iac._iad._iae._iaa._iab._iys._iyv._iyq._iAU._iAV._izh._h-8:nth-child(4) div.Common-Widgets-Datepicker-DateModal._ibU._ibV._iaf._idE._h-Y._im4._iai._ihz._j0g._jy1._iDB div._iaf._iEc._ia1._i7r._iv1._j0z._iPK._j0x._j0B._iai:nth-child(1) > div._iaf._iEU._iam._iai:nth-child(1)")
	WebElement StartDate; //div[contains(@id,'display-start')]//div[contains(@class,'startDate')][@xpath='1']
	
	@FindBy(xpath="//div[@spellcheck='false'][@aria-label='Departure date input'][contains(@id,'-depart-input')]")
	WebElement StartDateText;
		
	@FindBy(xpath = "//div[contains(@id,'-return-input')]")
	WebElement Return;
	
	@FindBy(xpath ="(//button[@aria-label='Search flights'])[1]")	
	WebElement SearchIcon;
	
	public KayakHomePage(WebDriver driver) throws IOException {		
		// This initElements method will create all WebElements
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	//Validating Homepage
	public String titleOfHomePage() {
		return driver.getTitle();
	}
					
	public void enterOriginCity(String Origin) throws InterruptedException, AWTException {
			
		functions.Click(CrossButton, "Cross Button");//To cancel default selection SFO
		functions.enterText(FromCityText, Origin, "From City");	
		Thread.sleep(2000);
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
						
	}
		
	public void enterDestinationCity(String Destination) throws InterruptedException, AWTException {
			
		functions.Click(ToCity, "To City");				
		functions.enterText(ToCityText, Destination, "To City");			
		Thread.sleep(1000);			
		r.keyPress(KeyEvent.VK_ENTER);
				
	}
		
	public void enterStartDate(String DepartureDate) throws InterruptedException, AWTException {
			
		functions.Click(StartDate, "Start Date");
		StartDateText.clear();
		StartDateText.sendKeys(DepartureDate);
		logger.log(LogStatus.INFO, "Departure Date entered");
		Thread.sleep(2000);	
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);				
			
	}

	public void enterReturnDate(String ReturnDate) throws InterruptedException, AWTException {
			
		r.keyPress(KeyEvent.VK_DELETE);
		r.keyRelease(KeyEvent.VK_DELETE);
		Return.sendKeys(ReturnDate);
		r.keyPress(KeyEvent.VK_ENTER);
		logger.log(LogStatus.INFO, "Return Date entered");						
			
	}
		
		public KayakSearchResultPage clickSearch() throws InterruptedException, AWTException {
			functions.Click(SearchIcon, "Search Icon");
			Thread.sleep(2000);
			r.keyPress(KeyEvent.VK_ESCAPE);
			return new KayakSearchResultPage();			
			
		}
		
}
