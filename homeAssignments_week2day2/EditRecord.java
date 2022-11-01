package homeAssignments_week2day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditRecord {

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
		//Click edit button and update first and company name
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_firstName']")).clear();
		String updatedfname = "updatedfname";
		driver.findElement(By.xpath("//input[@id='updateLeadForm_firstName']")).sendKeys(updatedfname);
		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
		String updatedcompname = "updatedcompanyname";		
		driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(updatedcompname);
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		Thread.sleep(5000);
		//validate if company, first name are updated
		String loadedfirstName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		String loadedlastName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		if((loadedfirstName.equals(updatedfname))&&(loadedlastName.contains(updatedcompname))) 
		{
			System.out.println("company name and first name updated successfully");
		}
		else 
		{
			System.out.println("company name and first name updated are not Saved successfully");
		}
		
		}
	}

