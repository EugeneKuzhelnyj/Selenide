package selenide;

import org.openqa.selenium.MutableCapabilities;

public class CapabilityFactory {

    public static MutableCapabilities getCapabilities(String browserType) {
        return switch (browserType){
            case "firefox" -> BrowserManager.getFirefoxOptions();
            case "chrome" -> BrowserManager.getChromeOptions();
            case "edge" -> BrowserManager.getEdgeOptions();
            case "safari" -> BrowserManager.getSafariOptions();
            default ->  throw new IllegalArgumentException("No such driver exist" + System.getProperty("remote.driver.type"));
        };
    }

}
