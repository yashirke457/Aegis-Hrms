package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EssentialPlan {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://qa.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("noblehrc@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		driver.findElement(By.linkText("Go To Organisation")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//button[text()='Setup'])[5]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//h1[text()='Employee']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Onboarding")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.name("first_name")).sendKeys("Deepak");
		driver.findElement(By.name("last_name")).sendKeys("Shinde");
		driver.findElement(By.name("date_of_birth")).sendKeys("06/25/2000");
		driver.findElement(By.name("email")).sendKeys("d@essential.com");
		driver.findElement(By.name("phone_number")).sendKeys("9162837465");
		driver.findElement(By.name("address")).sendKeys("Pune");
		driver.findElement(By.name("pwd"));
		driver.findElement(By.xpath("//input[@value = 'male']")).click();
//		driver.findElement(By.xpath("//input[@value = 'female']")).click();
		driver.findElement(By.name("adhar_card_number")).sendKeys("248027283942");
		driver.findElement(By.name("pan_card_number")).sendKeys("NXBAT1928P");
		driver.findElement(By.name("bank_account_no")).sendKeys("2837199138291");
		driver.findElement(By.name("citizenship")).sendKeys("Indian");
//		driver.findElement(By.name("uanNo"));
//		driver.findElement(By.name("esicNo"));
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.name("empId")).sendKeys("AT-038");
		driver.findElement(By.id("react-select-12-input")).sendKeys("development"+Keys.ENTER);
		driver.findElement(By.id("react-select-13-input"));
		driver.findElement(By.id("react-select-14-input"));
		driver.findElement(By.name("companyemail")).sendKeys("argan@gmail.com");
		driver.findElement(By.name("joining_date")).sendKeys("08/24/2020");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		driver.findElement(By.name("confirmPassword")).sendKeys("Pass@123");
		driver.findElement(By.id("react-select-15-input")).sendKeys("employee"+Keys.ENTER);
		driver.findElement(By.id("react-select-16-input")).sendKeys("general"+Keys.ENTER);
		driver.findElement(By.id("react-select-17-input")).sendKeys("d-19"+Keys.ENTER);
		driver.findElement(By.id("react-select-18-input")).sendKeys("pune"+Keys.ENTER);
		driver.findElement(By.id("react-select-19-input")).sendKeys("full-time"+Keys.ENTER);
		driver.findElement(By.id("react-select-20-input")).sendKeys("full-time"+Keys.ENTER);
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		Thread.sleep(3000);
		
	}

}
