package hw4OOP;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static java.util.Arrays.asList;

/**
 * Created by dmitryk on 31.10.15 1:53
 */

public class TodoOOPMVCSmokeTest extends AtTodoMVCPageWithClearedDataAfterEachTest {

    @Test
    public void testTodoMVC() {

        createTasks("1");
        toggleTask("1");

        filterActive();

        createTasks("2", "3");
        assertNames("2", "3");
        assertItemsLeftCounter("2");

        editTask("2", "New").pressEnter();
        assertNames("New", "3");

        toggleALL();
        assertItemsLeftCounter("0");

        filterCompleted();

        editTask("1", "will not be saved").sendKeys(Keys.ESCAPE);

        toggleTask("1");

        assertItemsLeftCounter("1");

        clearCompleted();

        filterAll();

        assertNames("1");

        toggleTask("1");
        deleteTask("1");
        assertNoTasksVisible();

    }

    static ElementsCollection tasks = $$("#todo-list li");


    @Step
    public void createTasks(String... names) {
        for(String name: asList(names)) {
            $("#new-todo").setValue(name).pressEnter();
        }
    }

    @Step
    public static SelenideElement editTask(String name, String newName) {
        tasks.find(text(name)).find(".view label").doubleClick();
        return tasks.find(cssClass("editing")).find(".edit").setValue(newName);
    }

    @Step
    public void deleteTask(String name) {
        tasks.find(text(name)).hover().find(".destroy").click();
    }

    @Step
    public void assertNames(String... names) {
        tasks.filter(visible).shouldHave(exactTexts(names));
    }

    @Step
    public void toggleTask(String name) {
        tasks.find(exactText(name)).find(".toggle").click();
    }

    @Step
    public void toggleALL() {
        $("#toggle-all").click();
    }

    @Step
    public void clearCompleted(){
        $("#clear-completed").click();
    }

    @Step
    public void assertNoTasksVisible() {
        tasks.shouldBe(empty);
    }

    @Step
    public static void filterAll() {
        $(By.linkText("All")).click();
    }

    @Step
    public static void filterActive() {
        $(By.linkText("Active")).click();
    }

    @Step
    public static void filterCompleted() {
        $(By.linkText("Completed")).click();
    }

    @Step
    public static void assertItemsLeftCounter(String text) {
        $("#todo-count>strong").shouldHave(text(text));
    }

}
