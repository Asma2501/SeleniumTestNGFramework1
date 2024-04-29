package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	public WebDriver driver;  // This dirver is null--this dont have any scope 

	// we will store locators here --

	// driver.fidElemet(By.xpath"").click();
	private By login = By.xpath("//a[text()='Login']");
	private By email = By.xpath("//input[@name='email']");
	private By password = By.xpath("//input[@name='password']");
	private By SubmitButton = By.xpath("//input[@type='submit']");
	private By ActualRslt=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
   
    private By Actual=By.xpath("//h2[text()='My Account']");
	
	
	public LoginPageObjects(WebDriver driver2) {
		this.driver=driver2;
	}
	
	public WebElement clickOnLogin() {
		return driver.findElement(login );
	}

	public WebElement enterEmail() {
		return driver.findElement(email);
	}

	public WebElement enterPassword() {
		return driver.findElement(password);
	}

	public WebElement clickOnSubmitButton() {
		return driver.findElement(SubmitButton);
	}
	public WebElement ActualRslt()
	{
		return driver.findElement(ActualRslt);
	}
	public WebElement Actual()
	{
		return driver.findElement(Actual);
	}
	

}


