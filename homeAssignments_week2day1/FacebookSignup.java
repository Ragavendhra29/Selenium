package homeAssignments_week2day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Initialize webdriver and chrome driver and add waittime
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//launch facebook signup page
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		//click on create new account button
		driver.findElement(By.linkText("Create New Account")).click();
	
		//Enter relevent data		
		driver.findElement(By.name("firstname")).sendKeys("Test1");
		driver.findElement(By.name("lastname")).sendKeys("test123");
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
		driver.findElement(By.id("password_step_input")).sendKeys("@Newpassword12");
		
		//use select class
		WebElement select1 =driver.findElement(By.name("birthday_day"));
		Select test = new Select(select1);
		test.selectByVisibleText("29");
		
		WebElement select2 =driver.findElement(By.id("month"));
		Select test2 = new Select(select2);
		test2.selectByIndex(1);
		
		WebElement select3 =driver.findElement(By.name("birthday_year"));
		Select test3 = new Select(select3);
		test3.selectByValue("1996");
		
		//select checkbox		
		driver.findElement(By.name("sex")).click();
		
	}

}
