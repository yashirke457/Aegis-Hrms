package base;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateNewSurvey {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("noblehrc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("Login successfull");
		
		driver.findElement(By.linkText("Go To Organisation")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//h1[text()='Communication'])[2]")).click();
		driver.findElement(By.xpath("//h1[text()='Employee Survey']")).click();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String date=LocalDate.now().format(formatter).toString().replace("-", "/");
		System.out.println(date);
		String futureDate=LocalDate.now().plusDays(10).format(formatter).toString().replace("-", "/");
		System.out.println(futureDate);
		
		driver.findElement(By.xpath("//button[text()='Create New Survey']")).click();
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")).sendKeys("Automation Testing");
		driver.findElement(By.xpath("(//p)[3]")).sendKeys("Basics");
		driver.findElement(By.xpath("//div[text()='Select Question Type']")).click();
		driver.findElement(By.xpath("//li[text()='Short Answer']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Question']")).sendKeys("What is automation testing?");
		driver.findElement(By.name("required-0")).click();
		
		driver.findElement(By.name("employeeSurveyStartingDate")).sendKeys(date);
		driver.findElement(By.name("employeeSurveyEndDate")).sendKeys(futureDate);
		driver.findElement(By.xpath("//span[text()='Do you want to select all employee emails?']")).click();
		driver.findElement(By.xpath("//button[text()='Select All']")).click();
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		System.out.println("New Survey created successfully");

		
		
		// logout
		Thread.sleep(5000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");

		Thread.sleep(3000);
		driver.quit();
		
	}

}
