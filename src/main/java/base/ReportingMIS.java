package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReportingMIS {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://app.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("neelamby@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@1234");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("Login successfull");
		
		driver.findElement(By.linkText("Go To Organisation")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Report']")).click();
		driver.findElement(By.linkText("Reporting MIS")).click();
		
		driver.findElement(By.xpath("//input[@id='react-select-3-input']")).sendKeys("attendance"+Keys.ENTER);
		
		//for salary data
//		driver.findElement(By.name("start")).sendKeys("6"+Keys.TAB+"2024");
//		driver.findElement(By.name("end")).sendKeys("7"+Keys.TAB+"2024");
		
		driver.findElement(By.xpath("(//*[local-name()='svg' and @class='h-5 w-5'])[1]")).click();
		driver.findElement(By.xpath("(//*[local-name()='svg' and @class='h-5 w-5'])[2]")).click();
		driver.findElement(By.xpath("(//button[text()='1'])[1]")).click();
		driver.findElement(By.xpath("//button[text()='31']")).click();
//		driver.findElement(By.xpath("//input[@id='react-select-4-input']")).sendKeys("suyash"+Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()=' Generate Report']")).click();
		Thread.sleep(10000);
		System.out.println("Report File downloaded successfully");
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");

		Thread.sleep(3000);
		driver.quit();
		
	}

}
