package essential;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseDriverSetup{
	public static WebDriver getDriver() {
		ChromeOptions options = new ChromeOptions();

		options.addArguments("--disable-notifications");
		options.addArguments("--incognito");

		// Set unique user profile
		String uniqueProfile = System.getProperty("java.io.tmpdir") + "profile-" + System.currentTimeMillis();
		options.addArguments("--user-data-dir=" + uniqueProfile);

		// Disable password manager and autofill
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("profile.default_content_setting_values.notifications", 2);
		prefs.put("autofill.profile_enabled", false);
		prefs.put("autofill.credit_card_enabled", false);
		options.setExperimentalOption("prefs", prefs);

		// Add GitHub Actions headless settings if needed
		if (System.getenv("GITHUB_ACTIONS") != null) {
		    options.addArguments("--window-size=1920,1080");
		    options.addArguments("--headless=new");
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-dev-shm-usage");
		    options.addArguments("--disable-gpu");
		}

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
    }
}
