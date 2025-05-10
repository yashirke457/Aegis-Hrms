package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeaveManagement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("r@basics.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Login successfull");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Attendance']")).click();
		driver.findElement(By.xpath("//h1[text()='Attendance Calender']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='07']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@aria-labelledby='demo-simple-select-label demo-simple-select']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Casual leave']")).click();
		driver.findElement(By.xpath("(//button[text()='Apply'])[2]")).click();
		System.out.println("Leave Request raised Successfully");
		
		//deleting raised leave request
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='Casual leave']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("deleteReason")).sendKeys("Invalid");
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		System.out.println("Leave request deleted successfully");
		Thread.sleep(4000);
		
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");

		Thread.sleep(3000);
		driver.quit();
	}

}
