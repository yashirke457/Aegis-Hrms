package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SalaryManagement {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		
		try {
		//login
		driver.findElement(By.name("email")).sendKeys("autotest@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Login successfull");
		
		driver.findElement(By.linkText("Go To Organisation")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[text()='Setup'])[2]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
		driver.findElement(By.xpath("//h1[text()='Salary Management']")).click();
		
		
		driver.findElement(By.xpath("//input[@placeholder='Search Employee Name....']")).sendKeys("rohit"+Keys.ENTER);
		
		driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
		driver.findElement(By.xpath("//li[@aria-label='Manage Salary']")).click();
		
		driver.findElement(By.name("Basic")).sendKeys(Keys.CONTROL+ "a");
		driver.findElement(By.name("Basic")).sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.name("Basic")).sendKeys("15000"+Keys.TAB+"0"+Keys.TAB+"0"+Keys.TAB+"1000"+Keys.TAB+"0"+Keys.TAB+"0"+Keys.TAB+"0"+Keys.TAB+"300");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='MoreVertIcon']")).click();
		driver.findElement(By.xpath("//li[@aria-label='Calculate Salary']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='month']")).sendKeys("O"+Keys.ENTER);
		Thread.sleep(3000);
//		driver.findElement(By.xpath("//button[text()='Download PDF']"));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		System.out.println("Salary management complted successfully");
		
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");
		
		//login with employee
		driver.findElement(By.name("email")).sendKeys("r@basics.com	");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		System.out.println("Employee Login successfull");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//h1[text()='Payroll']")).click();
		driver.findElement(By.xpath("//h1[text()='Pay Slip']")).click();
		driver.findElement(By.xpath("//input[@type='month']")).sendKeys("O"+Keys.ENTER);
		Thread.sleep(3000);
		
		Actions actions = new Actions(driver);
		actions.sendKeys(org.openqa.selenium.Keys.PAGE_DOWN).perform();
		
		driver.findElement(By.xpath("//button[@aria-label='Download your payslip as a PDF']")).click();
		System.out.println("Pay Slip PDF downloaded");
		Thread.sleep(5000);
		
		// logout with employee
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Employee Logout successfull");
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
