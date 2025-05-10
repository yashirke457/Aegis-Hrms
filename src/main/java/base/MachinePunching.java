package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MachinePunching {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		
		try {
			driver.findElement(By.name("email")).sendKeys("autotest@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass@123");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			System.out.println("Admin Login done successfully");

			driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
			driver.findElement(By.xpath("(//button[text()='Setup'])[2]")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//h1[text()='Machine Punching']")).click();
			driver.findElement(By.xpath("//h1[text()='Calendar View']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//button[@aria-label='view']")).click();
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']")).click();
			Thread.sleep(2000);
			
			String email=driver.findElement(By.xpath("(//td[@class='py-3 pl-6'])[3]")).getText();
			

			Thread.sleep(3000);
			driver.findElement(By.id("basic-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Admin Logout done successfully");
			
			
			//Employee login
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("password")).sendKeys("Pass@123");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Login']")).click();
			System.out.println("Employee Login done successfully");
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//h1[text()='Machine Punching']")).click();
			driver.findElement(By.xpath("//h1[text()='Missed Justify']")).click();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='AssignmentIcon'])[1]")).click();
			driver.findElement(By.name("justify")).sendKeys("NA");
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			System.out.println("Missed justify reason added successfully");
			
			Thread.sleep(3000);
			driver.findElement(By.id("basic-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Employee Logout done successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
