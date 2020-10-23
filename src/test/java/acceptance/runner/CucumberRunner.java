package acceptance.runner;

import com.codeborne.selenide.Configuration;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"acceptance.steps"},
        tags = "@acceptance"
)
public class CucumberRunner {

        @BeforeClass
        public static void setup() throws IOException {
            ChromeOptions chromeOptions = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            chromeOptions.setExperimentalOption("prefs", prefs);
            Configuration.browserCapabilities = new DesiredCapabilities();
            Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            Configuration.timeout = 10000;
            Properties qualityProperties = new Properties();
            qualityProperties.load(Objects.requireNonNull(
                    CucumberRunner.class.getClassLoader().getResourceAsStream("selenide.properties")
            ));
            Configuration.headless = Boolean.parseBoolean(qualityProperties.getProperty("headless"));
            Configuration.savePageSource = false;
            Configuration.screenshots = false;
            Configuration.browserSize = qualityProperties.getProperty("browserSize");
            Configuration.baseUrl = qualityProperties.getProperty("baseUrl");
            Configuration.browser = qualityProperties.getProperty("browser");
            if (qualityProperties.getProperty("browser").equals("chrome")) {
                LoggingPreferences logPrefs = new LoggingPreferences();
                logPrefs.enable(LogType.BROWSER, Level.ALL);
                logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
                Configuration.browserCapabilities.setCapability("goog:loggingPrefs", logPrefs);
            }
        }
}
