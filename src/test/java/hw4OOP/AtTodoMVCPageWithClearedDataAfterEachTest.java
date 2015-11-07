package hw4OOP;

import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by dmitryk on 31.10.15 19:38
 */
public class AtTodoMVCPageWithClearedDataAfterEachTest extends BaseTest {

    @Before
    public void openToMVCPage() {
        open("http://todomvc.com/examples/troopjs_require/#/");
        getWebDriver().navigate();
    }

    @After
    public void clearData() {
        executeJavaScript("localStorage.clear()");
    }
}
