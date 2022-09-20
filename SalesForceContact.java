package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Launch the url 
		
		driver.get("https://login.salesforce.com");
		// Login
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password#123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		
		//click on toggle menu
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		
		//click on view all 
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		
		//click on Sales 
		driver.findElement(By.xpath("//p[text()='Sales']")).click(); 
		
		//click on Opportunities tab
		
        WebElement Opp = driver.findElement(By.xpath("(//span[text()= 'Opportunities'])[1]"));
     	driver.executeScript("arguments[0].click();", Opp);
     	Thread.sleep(1000);
     	
     	//Click on Accounts tab
     	
     	WebElement acc = driver.findElement(By.xpath("//a[@title='Accounts']"));
     	driver.executeScript("arguments[0].click();", acc);
     	Thread.sleep(1000);
     	
     	//Click on New button
    	
     	driver.findElement(By.xpath("//div[@title='New']")).click(); 
    	Thread.sleep(4000);
    	
   	    //click on enter your name
    	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("XYZ");
    	
    	//click on ownership as public 
    	
    	driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[3]")).click();
    	
    	//verify Message
    	
    	String nameVerify = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[6]")).getAttribute("title");
		System.out.println("Account name is "+nameVerify);
		if(nameVerify.contains("xyz"))
		{
			System.out.println("Account name is verified");
		}
		else
		{
			System.out.println("Account name is not verified");
		}
	

	}

}
