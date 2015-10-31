package hw4OOP;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.junit.After;
import org.junit.Before;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by dmitryk on 31.10.15 19:38
 */
public class AtTodoMVCPageWithClearedDataAfterEachTest extends BaseTest{

    @Before
    public void OpenToMVCPage(){
        open("http://todomvc.com/examples/troopjs_require/#/");
        getWebDriver().navigate().refresh();
    }

    @After
    public void clearData() {
        executeJavaScript("localStorage.clear()");
    }
}
