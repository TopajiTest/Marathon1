package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSalesforce {

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
        WebElement acc = driver.findElement(By.xpath("(//span[text()= 'Opportunities'])[1]"));
     	driver.executeScript("arguments[0].click();", acc);
        
     	//Click on New button
     	driver.findElement(By.xpath("//div[@title='New']")).click();
		
     	//click on enter your name
     	driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("XYZ");
 		
     	//Choose date 
        driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("12/12/2022");
        
        // click on stage 
        
        WebElement Stage = driver.findElement(By.xpath("(//button[@class='slds-combobox__input slds-input_faux slds-combobox__input-value'])[1]"));
        driver.executeScript("arguments[0].click()",Stage );
		WebElement findElement2 = driver.findElement(By.xpath("(//span[@class='slds-media__body'])[2]/span"));
		driver.executeScript("arguments[0].click();", findElement2);
		Thread.sleep(9000);
        
		// Click on save
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
        
        String validateName = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]")).getAttribute("title");
        
        
        if (validateName.equals("xyz")) {
        	System.out.print("Opportunity name is verified");
        }
        else {
        	System.out.print("Opportunity name is not verified");
        }

	}

}
