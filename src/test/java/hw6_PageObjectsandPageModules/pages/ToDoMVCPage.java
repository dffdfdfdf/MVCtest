package hw6_PageObjectsandPageModules.pages;

import hw4OOP.AtTodoMVCPageWithClearedDataAfterEachTest;
import org.junit.Test;
import org.openqa.selenium.Keys;

/**
 * Created by dmitryk on 01.11.15 0:20
 */

public class ToDoMVCPage extends AtTodoMVCPageWithClearedDataAfterEachTest {

    @Test
    public void todoMVCTest() {

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
