package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPageObjects {

	public WebDriver driver;// Separately declared public webDriver here//this driver is null,doesnot have scope

	// we will store locators here --
	// driver.fidElemet(By.xpath"").click();

	private By MyAccount = By.xpath("//a[@title='My Account']");// like we declare int a=10; sameway we have By
																// variable=by.xpath"___ "
	private By Register = By.xpath("//a[text()='Register']");

	private By EnterFirstName = By.xpath("//input[@name='firstname']");
	private By EnterLastName = By.xpath("//input[@name='lastname']");
	private By EnterEmail = By.xpath("//input[@name='email']");
	private By EnterTelephone = By.xpath("//input[@name='telephone']");
	private By EnterPassword = By.xpath("//input[@name='password']");
	private By ConfirmPassword = By.xpath("//input[@name='confirm']");
	private By ClickonCheckbox = By.xpath("//input[@type='checkbox']");
	private By ClickonContinue = By.xpath("//input[@type='submit']");
	
	private By fnActual = By.xpath("//div[text()='First Name must be between 1 and 32 characters!']");
	private By lnActual = By.xpath("//div[text()='Last Name must be between 1 and 32 characters!']");
	private By InvalidEmailActual = By.xpath("//div[text()='E-Mail Address does not appear to be valid!']");
	private By TlphnActual = By.xpath("//div[text()='Telephone must be between 3 and 32 characters!']");
	private By invalidpwdActual = By.xpath("//div[text()='Password must be between 4 and 20 characters!']");
	
		
	//created the constructor here so that it provides scope for 'verifyregistrationtestcases' class
	public RegistrationPageObjects(WebDriver driver2) {
		this.driver=driver2;
	}

	public WebElement clickOnMyAccount() {
		return driver.findElement(MyAccount);
	}

	public WebElement clickOnRegister() {
		return driver.findElement(Register);
	}

	public WebElement EnterFirstName() {
		return driver.findElement(EnterFirstName);
	}

	public WebElement EnterLastName() {
		return driver.findElement(EnterLastName);
	}

	public WebElement EnterEmail() {
		return driver.findElement(EnterEmail);
	}

	public WebElement EnterTelephone() {
		return driver.findElement(EnterTelephone);
	}

	public WebElement EnterPassword() {
		return driver.findElement(EnterPassword);
	}
	
	public WebElement ConfirmPassword() {
		return driver.findElement(ConfirmPassword);
	}

	public WebElement ClickonCheckbox() {
		return driver.findElement(ClickonCheckbox);
	}

	
	public WebElement ClickonContinue() {
		return driver.findElement(ClickonContinue);
	}
	
	public WebElement fnActual() {
		return driver.findElement(fnActual);
	}
	
	public WebElement lnActual() {
		return driver.findElement(lnActual);
	}
	
	public WebElement InvalidEmailActual() {
		return driver.findElement(InvalidEmailActual);
	}
	
	public WebElement TlphnActual() {
		return driver.findElement(TlphnActual);
	}
	public WebElement invalidpwdActual() {
		return driver.findElement(invalidpwdActual);
	}

}
