package essential;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginLogout {

//    private WebDriver driver;
//
//    @BeforeClass
//    public void setup() {
//    	
//        driver = BaseDriverSetup.getDriver();
////        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//        driver.get("https://app.aegishrms.com/sign-in");
//        System.out.println("=========================================================");
//        System.out.println("LOGIN AND LOGOUT");
//    }
//
//    @Test
//    public void adminLoginLogout() throws InterruptedException {
//        login("automationscripts@gmail.com", "Pass@123");
//        System.out.println("Admin Login done successfully");
//
//        // Navigate to Organisation
//        driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
//        driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
//
//        logout();
//        System.out.println("Admin Logout done successfully");
//    }
//
//    @Test(dependsOnMethods = "adminLoginLogout")
//    public void employeeLoginLogout() throws InterruptedException {
//        login("employee@raulflauren.com", "Pass@123");
//        System.out.println("Employee Login done successfully");
//
//        logout();
//        System.out.println("Employee Logout done successfully");
//    }
//
//    private void login(String email, String password) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//        driver.get("https://app.aegishrms.com/sign-in"); // ensure correct page
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
//        driver.findElement(By.name("password")).sendKeys(password);
//        driver.findElement(By.xpath("//button[text()='Login']")).click();
//    }
//
//    private void logout() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//        // Click profile dropdown (safe to wrap with wait)
//        try {
//            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            shortWait.until(ExpectedConditions.elementToBeClickable(By.id("basic-button"))).click();
//        } catch (Exception e) {
//            System.out.println("⚠️ Failed to open profile dropdown: " + e.getMessage());
//            return;
//        }
//
//        // Wait for and click logout, ensure it’s actually visible
//        try {
//            By logoutBtn = By.xpath("//div[normalize-space(text())='Log out']");
//            wait.until(ExpectedConditions.presenceOfElementLocated(logoutBtn));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
//            wait.until(ExpectedConditions.elementToBeClickable(logoutBtn)).click();
//        } catch (Exception e) {
//            System.out.println("❌ Logout button not found or clickable in headless mode: " + e.getMessage());
//        }
//    }
//
//    @AfterClass
//    public void teardown() throws InterruptedException {
//        if (driver != null) {
//            Thread.sleep(3000); // Ensure any lingering tasks are completed
//            System.out.println("=========================================================");
//            driver.quit();
//        }
//    }
	
	
	public static WebDriver driver;
	@Test(priority = 1)
	public void userLogin() throws InterruptedException
	{
		driver= BaseDriverSetup.getDriver();   
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://qa.aegishrms.com/");
		driver.findElement(By.id("email")).sendKeys("qatest@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Pass@123");
	    WebElement button = driver.findElement(By.xpath("//button[text()='Login']"));
	    button.click();
	    System.out.println("Login done successful");
	}
	
	@Test(priority = 2)
	public void userLogout() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[class='MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault css-1llrwy8']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/ul/div/li[2]")).click();
		System.out.println("Logout done successful");
		driver.quit();
	}
	
}
