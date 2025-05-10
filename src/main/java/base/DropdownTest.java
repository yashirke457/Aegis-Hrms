package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropdownTest {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		
			driver.findElement(By.name("email")).sendKeys("manager@gmail.com");
			driver.findElement(By.name("password")).sendKeys("Pass@123");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[text()='Log in']")).click();
			System.out.println("Login done successfully");
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[local-name()=\"svg\" and @data-testid=\"MenuIcon\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("react-select-4-input")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("react-select-4-input")).sendKeys("emp"+Keys.ENTER);
			Thread.sleep(3500);
			
			
			Thread.sleep(3000);
			driver.findElement(By.id("basic-button")).click();
			driver.findElement(By.xpath("//div[text()=' Log out']")).click();
			System.out.println("Logout done successfully");
			
		Thread.sleep(3000);
		driver.quit();
		
	}

}
