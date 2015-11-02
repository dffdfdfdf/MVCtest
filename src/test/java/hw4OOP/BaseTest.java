package hw4OOP;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import com.task.ver1.TodoMVCTest;
import org.junit.After;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

/**
 * Created by dmitryk on 31.10.15 20:17
 */
public class BaseTest extends TodoMVCTest {

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
