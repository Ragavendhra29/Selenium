package homeAssignments_week2day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//initiate chromedriver
		WebDriverManager.chromedriver().setup();		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		
		//log in to application
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[contains(@class,'btn')]")).click();
		Thread.sleep(5000);
		//get and print title
		String title=driver.getTitle();
		System.out.println(title);
		//log out
		driver.findElement(By.linkText("Log Out")).click();
		driver.close();
		
	}

}
