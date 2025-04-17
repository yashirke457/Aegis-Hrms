package enterprise;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExpenseManagement {

    public static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void completeExpenseManagementFlow() throws Exception {
        superAdminLoginAndNavigate();
        System.out.println("Admin login done successfully");
        navigateToExpenseCreation();
        fillExpenseReportDetails();
        submitExpenseReport();

        managerApprovalProcess();

        superAdminFinalApproval();
        System.out.println("Script ended=============");
    }

    private void superAdminLoginAndNavigate() throws InterruptedException {
        driver.get("https://qa.aegishrms.com/");
        login("qatest@gmail.com", "Pass@123");

        driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
        driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();
    }

    private void navigateToExpenseCreation() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Management'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Dashboard'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='Create New']")).click();
    }

    private void fillExpenseReportDetails() throws InterruptedException {
        driver.findElement(By.name("reportDetails.reportName")).sendKeys("Casual Report");
        driver.findElement(By.name("reportDetails.reportDate")).sendKeys("1242025");

        driver.findElement(By.id("react-select-3-input")).click();
        driver.findElement(By.xpath("//div[text()='Other Expenses']")).click();

        driver.findElement(By.id("react-select-4-input")).click();
        driver.findElement(By.xpath("//div[text()='undefined undefined']")).click();
    }

    private void submitExpenseReport() throws InterruptedException, AWTException {
        driver.findElement(By.name("expenseName")).sendKeys("New Casual Expense");

        driver.findElement(By.id("react-select-5-input")).click();
        driver.findElement(By.xpath("//div[text()='Food']")).click();

        driver.findElement(By.name("amount")).sendKeys("1000");
        WebElement region = driver.findElement(By.name("region"));
        region.sendKeys("Dubai");
        region.click();

        Thread.sleep(1000);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        driver.findElement(By.cssSelector("input[placeholder='Enter expense description']")).sendKeys("Sample expense description");
        driver.findElement(By.xpath("//button[text()='Add Expense to Report']")).click();
        driver.findElement(By.xpath("//button[text()='Submit Report']")).click();
        Thread.sleep(1000);
    }

    private void managerApprovalProcess() throws InterruptedException {
        driver.quit(); // close super admin session
        setup(); // reinitialize driver
        driver.get("https://qa.aegishrms.com/");
        login("manager1@gmail.com", "Pass@123");

        Thread.sleep(1000);
        driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='NotificationsIcon'])")).click();
        driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='KeyboardArrowRightIcon'])")).click();
        driver.findElement(By.xpath("//span[text()='Expense Management']")).click();
        driver.findElement(By.xpath("(//div[@class='flex items-center gap-3'])[1]")).click();

        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Management'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Dashboard'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='View Approvals']")).click();
        driver.findElement(By.xpath("(//button[text()='View Details'])[last()]")).click();

        driver.findElement(By.xpath("(//button[text()='Expense Items'])[1]")).click();
        driver.findElement(By.xpath("(//button[text()='Approve'])[1]")).click();
        driver.findElement(By.xpath("//textarea[@placeholder='Enter reason...']")).sendKeys("Manager approval");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
    }

    private void superAdminFinalApproval() throws InterruptedException {
        driver.quit(); // close manager session
        setup(); // reinitialize driver
        driver.get("https://qa.aegishrms.com/");
        login("qatest@gmail.com", "Pass@123");

        driver.findElement(By.xpath("//button[text()='Go To Organisation']")).click();
        driver.findElement(By.xpath("(//button[text()='Setup'])[1]")).click();

        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Management'])[1]")).click();
        driver.findElement(By.xpath("(//h1[text()='Expense Dashboard'])[1]")).click();
        driver.findElement(By.xpath("//a[text()='View Approvals']")).click();
        driver.findElement(By.xpath("(//button[text()='View Details'])[last()]")).click();
        driver.findElement(By.xpath("(//button[text()='Expense Items'])[1]")).click();
    }

    private void login(String email, String password) throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
