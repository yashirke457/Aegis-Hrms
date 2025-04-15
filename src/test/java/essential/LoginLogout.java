package essential;

import java.time.Duration;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginLogout {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
    	
    	ChromeOptions options = new ChromeOptions();
        // Generate a unique temp user-data-dir to avoid session conflict
        String uniqueProfile = "/tmp/chrome_profile_" + UUID.randomUUID();
        options.addArguments("--user-data-dir=" + uniqueProfile);

        // Recommended for CI environments
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless"); // Optional: only if you don�t need browser UI

        driver = new ChromeDriver(options);
//        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://app.aegishrms.com/sign-in");
        System.out.println("=========================================================");
        System.out.println("LOGIN AND LOGOUT");
    }

    @Test
    public void adminLoginLogout() throws InterruptedException {
        login("automationscripts@gmail.com", "Pass@123");
        System.out.println("Admin Login done successfully");

        // Navigate to Organisation
        driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
        driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();

        logout();
        System.out.println("Admin Logout done successfully");
    }

    @Test(dependsOnMethods = "adminLoginLogout")
    public void employeeLoginLogout() throws InterruptedException {
        login("employee@raulflauren.com", "Pass@123");
        System.out.println("Employee Login done successfully");

        logout();
        System.out.println("Employee Logout done successfully");
    }

    private void login(String email, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://app.aegishrms.com/sign-in"); // ensure correct page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    private void logout() throws InterruptedException {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(3000);
        driver.findElement(By.id("basic-button")).click();
        By logoutBtn = By.xpath("//div[normalize-space(text())='Log out']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtn)).click();
    }

    @AfterClass
    public void teardown() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(3000); // Ensure any lingering tasks are completed
            System.out.println("=========================================================");
            driver.quit();
        }
    }
}
