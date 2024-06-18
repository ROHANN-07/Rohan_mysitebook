package app.mysitebook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import app.mysitebook.Pages.PageElements;
import app.mysitebook.base.BaseClass;

public class LoginAndVerify extends BaseClass{
	
	
    public BaseClass chrome;
    String expectedTitle;
	private PageElements elements;
	String actualDescription;
	String actualQuantity;
	String actualRateValue;

	
	
	@Test(priority= 1)
	public void insideSampleProject() {
		elements= new PageElements(driver);
		elements.selectSampleProject();;
		elements.selectQuoteId();
	}
	
	@Test(priority= 2)
	public void verifyTitle() {
		expectedTitle= "BSTPL";
		elements= new PageElements(driver);
		String actualTitle = elements.quotationTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@Test(priority= 3)
	public void verifyPriceFromTable() {
		SoftAssert softAssert= new SoftAssert();
		elements= new PageElements(driver);
		elements.getDesc();
		elements.getQuantity();
		elements.getRate();
		String expectedDescription = "dgertrg RCC labour on slab area basis";
		String expectedQuantity= "1414.84";
		String expectedRateValue= "140.00";
		actualDescription = elements.actualDesc[11];
		actualQuantity = elements.actualQuan[11];
		actualRateValue= elements.actualRate[11];
		
		softAssert.assertEquals(actualDescription, expectedDescription, "Description not matched");
		softAssert.assertEquals(actualQuantity, expectedQuantity, "Quantity not matched");
		softAssert.assertEquals(actualRateValue, expectedRateValue, "Rate not matched");
		
		softAssert.assertAll();
	}
	
	
	

}
