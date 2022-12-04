package selenide;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;

public class DriverProvider implements WebDriverProvider {
    Logger LOG = LoggerFactory.getLogger(DriverProvider.class);

    @Nonnull
    @Override
    public synchronized RemoteWebDriver createDriver(@Nonnull Capabilities capabilities) {
        LOG.info(System.getProperty("driverType"));
        try {
            return DriverManager.getDriverCreator(System.getProperty("driverType"));
        } catch (MalformedURLException e) {
            System.out.println("Remote driver connection failed");
            throw new RuntimeException(e);
        }
    }

}
