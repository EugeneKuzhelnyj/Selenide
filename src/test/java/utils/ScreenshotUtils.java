package utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public ScreenshotUtils() {
    }

    public static void takeScreenshotAndAttachToAllureReport(){
        File screenshot = Screenshots.takeScreenShotAsFile();
        try {
            Allure.addAttachment("Screenshot", FileUtils.openInputStream(screenshot));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
