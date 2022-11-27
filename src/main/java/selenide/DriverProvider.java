package selenide;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import javax.annotation.Nonnull;
import java.net.MalformedURLException;

public class DriverProvider implements WebDriverProvider {

    @Nonnull
    @Override
    public synchronized RemoteWebDriver createDriver(@Nonnull Capabilities capabilities) {
        try {
            return DriverManager.getDriverCreator(System.getProperty("driverType"));
        } catch (MalformedURLException e) {
            System.out.println("Remote driver connection failed");
            throw new RuntimeException(e);
        }
    }

}
