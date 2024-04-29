package testcases;
import java.text.NumberFormat;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testcase {	

		public static void main(String[] args) throws InterruptedException {

		  //  System.setProperty("webdriver.chrome.driver", "C:\\Users\\bhagy\\Downloads\\chromedriver_win32 (6)\\chromedriver.exe");
	        //Interface                 //Class
			    WebDriver driver = new ChromeDriver();  //123
	       
	        driver.get("https://naveenautomationlabs.com/opencart/");
	        
	        
	        
	        
	        

	        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("iphone");
	        
	        
	        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	       
	        
	        
	       WebElement obj= driver.findElement(By.xpath("//p[@class='price']"));
	       
	       //grab the text of iphone cost
	       String iphoneCost=obj.getText();  // $123.20 ExTac$101
	       
	       System.out.print(obj.getText());
	       // String count2=count1.substring(0, 7);
	       //Split the iphone cost with space
	       
	       String[] spl=iphoneCost.split(" ");
	     
	       System.out.println(Arrays.toString(spl));
	       
	       
	        String a=spl[0];  //$123.20
	        
	        
	        
	        String removeDollar = a;
	        String afterRemovingDollar = removeDollar.replaceAll("[$,]", ""); //123.20
	        
	    
	       // convert the string to  double
	        double d=Double.parseDouble(afterRemovingDollar);
	        System.out.println(d);//  123.20
	        Thread.sleep(5000);
	       
	       driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[3]")).click();
	       
	       //samsung code
	        driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
	        driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("samsung");
	        driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']")).click();
	        Thread.sleep(5000);
	       WebElement obj2= driver.findElement(By.xpath("(//p[@class='price'])[2]"));
	       String count3=obj2.getText();
	       
	       //  System.out.print(obj.getText());
	      //   String count4=count3.substring(0, 7);
	         String[]spl1=count3.split("\\s+");
	          String b=spl1[0];
	          System.out.println(b+"check");
	      //   System.out.println(count4);
	        // String b=count4;
	         // int  count3=a+a;
	          
	          
	         String k = b;
	         String newStr1 = k.replaceAll("[$,]", "");
	       //  System.out.println(newStr1);
	         double d2=Double.parseDouble(newStr1);
	         System.out.println(d2);  //241.99
	         
	         
	         
	         double d4=d+d2; //d4  365.19
	         
	         String t=("$"+d4); //  t= $365.19
	       //  System.out.println("$"+d4);
	         Thread.sleep(5000);
	         driver.findElement(By.xpath("(//i[@class='fa fa-shopping-cart'])[5]")).click();
	         Thread.sleep(5000);
	         driver.findElement(By.xpath("//div[@id='cart']")).click();
	        WebElement exp= driver.findElement(By.xpath("(//td[@class='text-right'])[12]"));
	        String p=exp.getText(); 
	        System.out.println(p);  //$365.19
	        
	       if (t.equals(p)) {
	    	   System.out.println("amount matching sucessfully");
	       }else {
	    	   System.out.println("amount not matching sucessfully");
	       }
	       
	   
	      
	        
	        
	        //driver.close();
	       
	          
			
		}
}
