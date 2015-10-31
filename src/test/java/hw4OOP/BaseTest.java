package hw4OOP;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

/**
 * Created by dmitryk on 31.10.15 20:17
 */
public class BaseTest {

    @After
    public void tearDown() throws IOException {
        screenshot();
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }
}
