package homeAssignments_week2day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
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
				driver.findElement(By.xpath("//p[@class='top']/input")).sendKeys("Democsr2");
				driver.findElement(By.xpath("(//form[@id='login']//input)[2]")).sendKeys("crmsfa");
				driver.findElement(By.xpath("//input[@class='inputLogin']/following::input[@class='decorativeSubmit']")).click();
				
				//Navigate to leads page
				driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
				driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
				
				//Find a duplicate lead record
				driver.findElement(By.xpath("//a[contains(text(),'Find Lead')]")).click();
				Thread.sleep(5000);
				
				//Enter email address and search for duplicate records
				driver.findElement(By.xpath("//span[text()='Email']")).click();				
				String emailid = "abc@gmail.com";
				driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(emailid);				
				driver.findElement(By.xpath("//tbody//button[text()='Find Leads']")).click();	
				Thread.sleep(5000);
				
				//Check if there is duplicate entry else skip task
				Boolean disp=	driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]")).isDisplayed(); 	
				if (disp==true) {
					String Id = driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]")).getText();
					System.out.println("Lead id for duplicate entry is "+Id);				
					String name= driver.findElement(By.xpath("(//div[contains(@class,'firstName')])[2]")).getText();
					System.out.println("First name of duplicate entry is "+name);				
					driver.findElement(By.linkText(Id)).click();
					//click Duplicate Lead button
					driver.findElement(By.linkText("Duplicate Lead")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//input[@name='submitButton']")).click();
					Thread.sleep(5000);
					String dupname = driver.findElement(By.id("viewLead_firstName_sp")).getText();
					if (dupname.equals(dupname)) {
						System.out.println("Duplicated successfully");
					}
					else {
						System.out.println("incorrect value duplicated");
					}
				}
				else {
					System.out.println("There is no duplicate entry for given email address");
				}
				driver.close();

	}

}
