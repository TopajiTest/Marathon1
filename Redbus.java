package marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Redbus {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-notifications");
			ChromeDriver driver=new ChromeDriver(options);
		
		
		//login
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//div[@class='fl search-box clearfix']//input[@id='src']")).sendKeys("Hyderabad");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='clearfix search-wrap']//input[@id='dest']")).sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='fl icon-calendar_icon-new icon-onward-calendar icon']")).click();
		driver.findElement(By.xpath("//td[text()='24']")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		//print number of buses available 
		String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.print(text);
		//select check box of sleeper 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='SLEEPER']")).click();
		//click on view seats 
		driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[1]")).click();
		String price = driver.findElement(By.xpath("//li[text()='2331']")).getText();
		System.out.print(price);
		String available = driver.findElement(By.xpath("//span[@class='seatSelMsg']")).getText();
		System.out.print(available);
	
		
		
		
	}


		
	}


