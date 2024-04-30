package testcases;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddtoCartTestCase {
	public static void main(String Args[]) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/");
		Thread.sleep(2000);

		// for adding iphone
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("iphone");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='search']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='button-group']/button[1]")).click();

		WebElement pricetag = driver.findElement(By.xpath("//p[@class='price']"));
		String pricetag1 = pricetag.getText();
		System.out.println(pricetag1);
		String[] pricetag1array = pricetag1.split("Ex Tax:");
		pricetag1 = pricetag1array[0].trim();
		System.out.println(pricetag1);

		String x = pricetag1.toString();
		System.out.println(x.length());
		String y = x.substring(1, pricetag1.length());
		System.out.println(y);
		double d = Double.parseDouble(y);

		// Split the iphone cost with space
		/*
		 * String[] spl=pricetag1.split("  "); System.out.println(Arrays.toString(spl));
		 * String a=spl[0]; //$123.20 System.out.println(a); String removeDollar = a;
		 * String afterRemovingDollar = removeDollar.replaceAll("[$]", ""); //123.20
		 * System.out.println(afterRemovingDollar); // convert the string to double
		 * double iphonefinalprice=Double.parseDouble(afterRemovingDollar);
		 * System.out.println(iphonefinalprice);// 123.20
		 */

		// for adding samsung phone
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys("samsung");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='button-group']/button)[4]")).click();

		WebElement pricetagsamsung = driver.findElement(By.xpath("(//p[@class='price'])[2]"));
		String pricetag2 = pricetagsamsung.getText();
		System.out.println(pricetag2);

		String z = pricetag2.toString();
		System.out.println(z.length());
		String z1 = z.substring(1, 8);
		System.out.println(z1);
		double e = Double.parseDouble(z1);

		double Totalprice = d + e;
		System.out.println(Totalprice);
		

		Thread.sleep(4000);

		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[3]")).click();
		Thread.sleep(4000);

		String finalprice1 = driver.findElement(By.xpath("(//td[@class='text-right'])[26]")).getText();
		String finalprice = finalprice1.substring(1);
		System.out.println(finalprice1.substring(1));
		double Finalprice = Double.parseDouble(finalprice);
		System.out.println(Finalprice);

		if (Totalprice==Finalprice) {
			System.out.println("Amount sucessfully matched");
		} else {
			System.out.println("Amount Mismatch");
		}

	}

}
