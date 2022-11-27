package selenide;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class DriverManager {
    public static final String REMOTE_URL = "http://192.168.100.8:4444/wd/hub";
    public static synchronized RemoteWebDriver getDriverCreator (String browserType) throws MalformedURLException {
        return switch (browserType) {
            case "chrome" -> new ChromeDriver();
            case "firefox" -> new FirefoxDriver();
            case "edge" -> new EdgeDriver();
            case "remote" -> new RemoteWebDriver(new URL(REMOTE_URL),CapabilityFactory.getCapabilities(System.getProperty("remote.driver.type")));
            default ->  throw new IllegalArgumentException("No such driver exist" + System.getProperty("remote.driver.type"));
        };
    }

}
