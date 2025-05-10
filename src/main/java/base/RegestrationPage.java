package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegestrationPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://app.aegishrms.com/sign-in");
		
		driver.findElement(By.linkText("Sign up for AEGIS")).click();
		
		driver.findElement(By.name("first_name")).sendKeys("Rohit");
		driver.findElement(By.name("middle_name")).sendKeys("kunal");
		driver.findElement(By.name("last_name")).sendKeys("Pawar");
		driver.findElement(By.name("phone")).sendKeys("7543267890");
		driver.findElement(By.name("email")).sendKeys("rohit@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		driver.findElement(By.name("confirmPassword")).sendKeys("Pass@123");
		driver.findElement(By.id("isChecked")).click();
		driver.findElement(By.xpath("//button[text()='Register Account']")).click();
		System.out.println("Registered successfully");
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
