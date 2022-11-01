package homeAssignments_week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteRecord {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//initiate chromedriver
		WebDriverManager.chromedriver().setup();		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//start chromedriver
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.getTitle();
		//login to application
		driver.findElement(By.xpath("//input[@name='USERNAME']")).sendKeys("Democsr2");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'decorativeSubmit')]")).click();
		//Navigate to leads page
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		//create a lead record
		driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
		driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys("Testcompanyname");
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("TestFirstname");
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Testlastname");	
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(5000);
		
		//Delete record
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();

	}

}
