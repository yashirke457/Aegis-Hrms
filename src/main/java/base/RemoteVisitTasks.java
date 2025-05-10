package base;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RemoteVisitTasks {
	
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("autotest@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Login successfull");
		
		driver.findElement(By.linkText("Go To Organisation")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[text()='Setup'])[4]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Remote Punch']")).click();
		driver.findElement(By.linkText("Remote Visit tasks")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text(),'Add task to employee']")).click();
		
		LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        String Date = today.format(formatter);
		
		Thread.sleep(2000);
		driver.findElement(By.name("title")).sendKeys("Demo");
		driver.findElement(By.name("description")).sendKeys("Aegis web demo");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("Wakad"+Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.name("deadlineDate")).sendKeys(Date);
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("r@gmail.com"+Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text(),'Submit']")).click();
	
		
		//Deletes added task
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='DeleteOutlineIcon']")).click();
		driver.findElement(By.xpath("//button[text(),'Delete']")).click();
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");

		Thread.sleep(3000);
		driver.quit();
	}
	

}
