package base;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoanManagement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("y@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("Login successfull");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
		driver.findElement(By.xpath("//h1[text()='Loan Management']")).click();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String date=LocalDate.now().plusMonths(1).format(formatter).toString().replace("-", "/");
		System.out.println(date);
		
		driver.findElement(By.xpath("//button[text()='Apply For Loan']")).click();
		driver.findElement(By.xpath("//div[@aria-haspopup]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='Personal loan']")).click();
		driver.findElement(By.id("outlined-adornment-password")).sendKeys("100000");
		driver.findElement(By.xpath("//input[@inputmode]")).click();
		driver.findElement(By.xpath("//input[@inputmode]")).sendKeys(date);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("100");
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//label[text()='Upload Document']"));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		System.out.println("Loan management done successfully");
		
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");

		Thread.sleep(3000);
		driver.quit();
		
	}

}
