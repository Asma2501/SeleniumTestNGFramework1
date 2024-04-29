package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodel.LoginPageObjects;
import pageobjectmodel.RegistrationPageObjects;
import resources.Baseclass;
import resources.CommonMethods;
import resources.Constant;

public class VerifyLoginTestcases extends Baseclass{
	@Test
	public void verifyLoginithValidData() throws IOException, InterruptedException {
		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
		
		rpo.clickOnMyAccount().click();

		LoginPageObjects lpo=new LoginPageObjects(driver);
		
		lpo.clickOnLogin().click();
		
		lpo.enterEmail().sendKeys(email);
		//Thread.sleep(4000);
		CommonMethods.handleWait(driver, 6, lpo.enterPassword());
		lpo.enterPassword().sendKeys("hii");//(Constant.password);
		lpo.clickOnSubmitButton().click();
		
		SoftAssert sa = new SoftAssert();

		String actual = lpo.Actual().getText();
		String expected =Constant.expected;
		sa.assertEquals(actual, expected);
		sa.assertAll();

	}
		
		@Test
		public void verifyLoginithInValidData() throws IOException, InterruptedException {
			
			RegistrationPageObjects rpo = new RegistrationPageObjects(driver);
			rpo.clickOnMyAccount().click();
			
			LoginPageObjects lpo=new LoginPageObjects(driver);
			lpo.clickOnLogin().click();
			
			lpo.enterEmail().sendKeys(email);//enter invalid email id or keep empty
			Thread.sleep(4000);
			lpo.enterPassword().sendKeys(Constant.invalidPassword);//enter invalid data or keep empty
			lpo.clickOnSubmitButton().click();
			
			SoftAssert sa = new SoftAssert();

			String Actual=lpo.ActualRslt().getText();
			String Expected=Constant.ExpctedRslt;
			sa.assertEquals(Actual,Expected);
			sa.assertAll();
	}


}
