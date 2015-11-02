package hw5FullTest;

import hw4OOP.AtTodoMVCPageWithClearedDataAfterEachTest;
import org.junit.Test;

/**
 * Created by dmitryk on 01.11.15 0:20
 */

public class TasksLifeCycleTest extends AtTodoMVCPageWithClearedDataAfterEachTest {

    @Test
    public void todoMVCTest() {

        createTasks("1");
        toggleTask("1");

        switchToActiveFilter();

        createTasks("2", "3");
        assertNames("2", "3");
        assertItemsLeftCounter("2");

        editTask("2", "New").pressEnter();
        assertNames("New", "3");

        toggleALL();
        assertItemsLeftCounter("0");

}
