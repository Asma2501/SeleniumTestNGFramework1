package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageobjectmodel.RegistrationPageObjects;
import resources.Baseclass;
import resources.CommonMethods;
import resources.Constant;

public class VerifyRegistrationTestcases extends Baseclass {

	@Test(priority=2)
	public void verifyRegisterationWithValidData() throws IOException, InterruptedException {
		/*//now we accessed this commonly from baseclass by adding common url in data.properties
		
		//driverInitilization();
		//driver.get("https://naveenautomationlabs.com/opencart/");*/
		
		
		
		// driver.findElement(By.xpath("accountxpath")).click();		
		//to avoid the above lines in framework we can follow below step
		//create object of registrationpageobjects class coz we have all our methods there
		//we can access them here by creating object of it
		
		RegistrationPageObjects Reg=new RegistrationPageObjects(driver);
		Reg.clickOnMyAccount().click();
		Reg.clickOnRegister().click();
		Reg.EnterFirstName().sendKeys(Constant.firstname);
		Reg.EnterLastName().sendKeys(Constant.lastname);
		
		/*"find notes below" Reg.EnterEmail().sendKeys("asjhhdg@gmail.com"); */
		
		Reg.EnterEmail().sendKeys(email);
		//Thread.sleep(4000);
		CommonMethods.handleWait(driver, 10, Reg.EnterTelephone());
		Reg.EnterTelephone().sendKeys(Constant.phone);
		Reg.EnterPassword().sendKeys(Constant.password);
		Reg.ConfirmPassword().sendKeys(Constant.confirmpassword);
		Reg.ClickonCheckbox().click();
		Reg.ClickonContinue().click();
	}

	@Test(priority=1)
	public void verifyRegisterationWithInValidData() throws IOException, InterruptedException {


		RegistrationPageObjects rpo = new RegistrationPageObjects(driver);

		rpo.clickOnMyAccount().click();
		rpo.clickOnRegister().click();
		rpo.ClickonContinue().click();

		//SoftAssert sa = new SoftAssert();

		String fnactual=rpo.fnActual().getText();
		String fnExpected = Constant.fnExpected;

		String lnactual=rpo.lnActual().getText();
		String lnExpected = Constant.lnExpected;
		
		String InvalidEmailActual =rpo.InvalidEmailActual().getText();
		String InvalidEmailExpected = Constant.InvalidEmailExpected;
		
		String TlphnActual = rpo.TlphnActual().getText();
		String TlphnExpected = Constant.TlphnExpected;		
		
		
		String invalidpwdActual = rpo.invalidpwdActual().getText();
		String invalidpwdExpected = Constant.invalidpwdExpected;
		
/*
		sa.assertEquals(fnactual, fnExpected);

		sa.assertEquals(lnactual, lnExpected);
		
		sa.assertEquals(invalidpwdActual, invalidpwdExpected);
		
		sa.assertEquals(InvalidEmailActual, InvalidEmailExpected);
		
		sa.assertEquals(TlphnActual, TlphnExpected);
		
		
		sa.assertAll();*/
		
		CommonMethods.handleAssertion(fnactual, fnExpected);
		CommonMethods.handleAssertion(lnactual, lnExpected);
		CommonMethods.handleAssertion(invalidpwdActual, invalidpwdExpected);		
		CommonMethods.handleAssertion(InvalidEmailActual, InvalidEmailExpected);
		CommonMethods.handleAssertion(TlphnActual, TlphnExpected);

	}
}
/* this code will run only once coz email has been registered at once so there's no scope again.
thats why we have generate random email id for each test case.so we can take help of method which
 generates random email ids in base class*/