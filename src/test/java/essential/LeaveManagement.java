package essential;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LeaveManagement {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
    	driver=BaseDriverSetup.getDriver();
    	driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://app.aegishrms.com");
        System.out.println("=========================================================");
        System.out.println("LEAVE MANAGEMENT");
    }

    @Test
    public void leaveManagement() throws InterruptedException {
    	
    	try {
        login("employee@raulflauren.com", "Pass@123");
        navigateToAttendanceCalendar();
        applyLeave("Casual leave");
        deleteLeaveRequest("Invalid");
        logout();
        
        System.out.println("=========================================================");
        System.out.println("âœ… LEAVE MANAGEMENT- PASSED");
        
    	}catch (Exception e) {
    		System.out.println("â�Œ LEAVE MANAGEMENT- FAILED");
            System.out.println("ðŸ”� Error Message: " + e.getMessage());
            e.printStackTrace();
		}
        
    }

    private void login(String email, String password) throws InterruptedException {
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        System.out.println("Login successful");
    }

    private void logout() throws InterruptedException {
        driver.findElement(By.id("basic-button")).click();
        driver.findElement(By.xpath("//div[text()=' Log out']")).click();
        System.out.println("Logout successful");
    }

    private void navigateToAttendanceCalendar() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@aria-label='open drawer']")).click();
        driver.findElement(By.xpath("//h1[text()='Attendance']")).click();
        driver.findElement(By.xpath("//h1[text()='Attendance Calender']")).click();
        Thread.sleep(2000);
    }

    private void applyLeave(String leaveType) throws InterruptedException {
    	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	WebElement date = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='07']/..")));
    	date.click();
    	WebElement applyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Apply']")));
    	applyButton.click();
    	WebElement selectField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-labelledby='demo-simple-select-label demo-simple-select']")));
    	selectField.click();
    	WebElement leaveTypeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='" + leaveType + "']")));
        leaveTypeButton.click();
        
        driver.findElement(By.xpath("(//button[text()='Apply'])[2]")).click();
        System.out.println("Leave Request raised successfully");
    }

    private void deleteLeaveRequest(String reason) throws InterruptedException {
        driver.findElement(By.xpath("//span[text()='Casual leave']/..")).click();
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        driver.findElement(By.name("deleteReason")).sendKeys(reason);
        driver.findElement(By.xpath("//button[text()='Delete']")).click();
        System.out.println("Leave request deleted successfully");
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000);
            System.out.println("=========================================================");
            driver.quit();
        }
    }
}
