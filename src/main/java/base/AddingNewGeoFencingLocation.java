package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddingNewGeoFencingLocation {
	
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
			driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
			driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//h1[text()='Geo Fencing']")).click();
			driver.findElement(By.xpath("//h1[text()='Add Geo Fencing']")).click();
			
			//Adds geo fence location
			driver.findElement(By.xpath("(//button[text()=' Add'])[1]")).click();
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("The onyx wakad");
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[@aria-label='Draw a circle']")).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath("//button[text()='Add']")).click();
			Thread.sleep(3000);
			System.out.println("Added geo fencing location successfully");
			
			//Views added geo fencing location
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
			driver.findElement(By.xpath("//li[text()='View']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='CloseIcon']")).click();
			Thread.sleep(3000);
			
			//Adds employee in the geo fence location
			driver.findElement(By.xpath("//button[text()='Manage Employee']")).click();
			driver.findElement(By.name("firstName")).sendKeys("mohit");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@class='checkbox']")).click();
			driver.findElement(By.xpath("//button[text()='Save']")).click();
			Thread.sleep(3000);
			System.out.println("Employee added successfully to the geo fence location");
			
			//Deletes the added geo location
			driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
			driver.findElement(By.xpath("//li[text()='Delete']")).click();
			Thread.sleep(3000);
			System.out.println("Deleted geo location deleted successfully");
			
			
			//Logout
			Thread.sleep(2000);
			driver.findElement(By.id("basic-button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Admin Logout done successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
