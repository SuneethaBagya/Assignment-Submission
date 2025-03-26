package com.todomvc.test;



import org.testng.annotations.*;
import org.todomvc.pageobjects.TodoPage;
import org.todomvc.utils.BaseTest;


public class TodoTest extends BaseTest {
    TodoPage todoPage;

    @BeforeMethod
    public void init() {
        todoPage = new TodoPage(driver);
    }

    @Test
    public void testAddTodo() {
        todoPage.addTodo("Buy Milk");
        assert todoPage.getTodos().size() > 0;
    }

    @Test
    public void testMarkCompleted() {
        todoPage.addTodo("Walk Dog");
        todoPage.markTodoCompleted("Walk Dog");
        // Add validation if needed
    }

    @Test
    public void testDeleteTodo() {
        todoPage.addTodo("Delete Me");
        todoPage.deleteTodo("Delete Me");
        // Add validation if needed
    }

    @Test
    public void testClearCompleted() {
        todoPage.addTodo("Complete Me");
        todoPage.markTodoCompleted("Complete Me");
        todoPage.clearCompleted();
        // Validate that the item is gone
    }

    @Test
    public void testFilterTodos() {
        todoPage.addTodo("Task 1");
        todoPage.addTodo("Task 2");
        todoPage.markTodoCompleted("Task 1");

        todoPage.applyFilter("Active");
        // Only Task 2 should show

        todoPage.applyFilter("Completed");
        // Only Task 1 should show
    }
}

