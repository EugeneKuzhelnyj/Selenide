package selenide;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class BrowserManager {

    public static MutableCapabilities getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserVersion", "107.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{add("TZ=UTC");}});
            put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
            put("enableVideo", true);
        }});
        return options;
    }

    public static MutableCapabilities getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("browserVersion", "106.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{add("TZ=UTC");}});
            put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
            put("enableVideo", true);
        }});
        return options;
    }

    public static MutableCapabilities getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setCapability("browserVersion", "106.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{add("TZ=UTC");}});
            put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
            put("enableVideo", true);
        }});
        return options;
    }

    public static MutableCapabilities getSafariOptions() {
        SafariOptions options = new SafariOptions();
        options.setCapability("browserVersion", "15.0");
        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
            put("name", "Test badge...");
            put("sessionTimeout", "15m");
            put("env", new ArrayList<String>() {{add("TZ=UTC");}});
            put("labels", new HashMap<String, Object>() {{put("manual", "true");}});
            put("enableVideo", true);
        }});
        return options;
    }

}
