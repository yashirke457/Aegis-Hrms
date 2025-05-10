package base;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvanceSalary {
	
	public static void main(String[] args) throws InterruptedException {
		
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://app.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("mohit@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("Login successfull");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
		driver.findElement(By.xpath("//h1[text()='Advance Salary']")).click();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String date=LocalDate.now().plusMonths(1).format(formatter).toString().replace("-", "/");
		
		driver.findElement(By.xpath("//button[text()='Apply For Advance Salary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(date+Keys.TAB+Keys.TAB+"1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");
		
	}

}
