package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplyForMissPunch {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		try {
		driver.get("https://qa.aegishrms.com/sign-in");
		//login
		driver.findElement(By.name("email")).sendKeys("p@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		System.out.println("Login successfull");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//h1[text()='Remote Punch']")).click();
		driver.findElement(By.linkText("Apply Miss For Punch")).click();
		
		driver.findElement(By.name("today")).sendKeys("8/20/2024");
		driver.findElement(By.xpath("//*[local-name()='svg' and @data-testid='AddIcon']/..")).click();
		
		Thread.sleep(2000);

        // Use JavaScript to ensure the element is interacted with properly
        WebElement locationInput1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=' css-19bb58m'])[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationInput1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locationInput1);
        Thread.sleep(2500);
        locationInput1.sendKeys("Wadgaonsheri");

        WebElement locationInput2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class=' css-1xc3v61-indicatorContainer'])[3]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationInput2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locationInput2);
        locationInput2.sendKeys("Onyx wakad" + Keys.ENTER);
        
		driver.findElement(By.name("start")).sendKeys("09:30:AM");
		driver.findElement(By.name("end")).sendKeys("06:30:PM");
		driver.findElement(By.name("distance")).sendKeys("22");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Apply']")).click();
		
		
		
		// logout
		Thread.sleep(3000);
		driver.findElement(By.id("basic-button")).click();
		driver.findElement(By.xpath("//div[text()=' Log out']")).click();
		System.out.println("Logout successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Thread.sleep(3000);
			driver.quit();
		}
		
		
	}

}
