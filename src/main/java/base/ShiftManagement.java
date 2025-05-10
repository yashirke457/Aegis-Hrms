package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShiftManagement {

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
		driver.findElement(By.xpath("//h1[text()='Shift Management']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='08']/..")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		driver.findElement(By.xpath("//div[@aria-haspopup='listbox']")).click();
		driver.findElement(By.xpath("//div[text()='Morning shift']")).click();
		driver.findElement(By.xpath("//button[text()='Apply for shift']")).click();
		Thread.sleep(2000);
		System.out.println("Shift Request raised Successfully");
		
		//Delete selected shift request
		driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@title='Morning shift']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");

		Thread.sleep(3000);
		driver.quit();
	}

}
