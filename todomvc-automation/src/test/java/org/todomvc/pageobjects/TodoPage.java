package org.todomvc.pageobjects;



import org.openqa.selenium.*;
import java.util.List;

public class TodoPage {
    WebDriver driver;

    public TodoPage(WebDriver driver) {
        this.driver = driver;
    }

    By todoInput = By.className("new-todo");
    By todoItems = By.cssSelector(".todo-list li");
    By clearCompletedBtn = By.className("clear-completed");
    By filterCompleted = By.linkText("Completed");
    By filterActive = By.linkText("Active");
    By filterAll = By.linkText("All");

    public void addTodo(String todoText) {
        driver.findElement(todoInput).sendKeys(todoText + Keys.ENTER);
    }

    public List<WebElement> getTodos() {
        return driver.findElements(todoItems);
    }

    public void markTodoCompleted(String todoText) {
        for (WebElement todo : getTodos()) {
            if (todo.getText().equals(todoText)) {
                todo.findElement(By.cssSelector("input.toggle")).click();
                break;
            }
        }
    }

    public void deleteTodo(String todoText) {
        for (WebElement todo : getTodos()) {
            if (todo.getText().equals(todoText)) {
                WebElement destroyBtn = todo.findElement(By.cssSelector("button.destroy"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", destroyBtn);
                break;
            }
        }
    }

    public void applyFilter(String filterName) {
        switch (filterName.toLowerCase()) {
            case "completed":
                driver.findElement(filterCompleted).click();
                break;
            case "active":
                driver.findElement(filterActive).click();
                break;
            case "all":
                driver.findElement(filterAll).click();
                break;
        }
    }

    public void clearCompleted() {
        driver.findElement(clearCompletedBtn).click();
    }
}
