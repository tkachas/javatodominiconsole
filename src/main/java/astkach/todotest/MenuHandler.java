
package astkach.todotest;

import java.io.IOException;
import java.util.Scanner;

public class MenuHandler {
    private final TaskManager manager;
    private final Scanner scanner;

    public MenuHandler(TaskManager manager, Scanner scanner) {
        this.manager = manager;
        this.scanner = scanner;
    }

    public void addTask() {
        System.out.println("Input task description: ");
        String description = scanner.nextLine();
        manager.addTask(description);
        System.out.println("Task added...");
    }

    public void deleteTask() {
        System.out.println("Input task id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (manager.deleteTask(id)) {
            System.out.println("Task deleted");
        } else {
            System.out.println("Task not found. ID - " + id);
        }
    }

    public void markTaskAsCompleted() {
        System.out.println("Input task id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        if (manager.markTaskAsCompleted(id)) {
            System.out.println("\u001B[32mTask completed\u001B[0m");
        } else {
            System.out.println("Task not found. ID - " + id);
        }
    }

    public void printAllTasks() {
        manager.printAllTasks();
    }

    public void saveToFile() throws IOException {
        System.out.println("Enter file name: ");
        String filename = scanner.nextLine();
        manager.saveToFile(filename);
    }

    public void loadFromFile() throws IOException {
        System.out.println("Enter file name: ");
        String filename = scanner.nextLine();
        manager.loadFromFile(filename);
    }

    public void getTaskById() {
        System.out.println("Input task id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Task task = manager.getById(id);

        if (task != null) {
            String taskDesc = task.getDescription();
            String status = task.isCompleted() ? "[DONE]" : "[CREATED]";

            System.out.printf("%d. %s %s%n",
                    task.getId(),
                    status,
                    taskDesc
            );
        } else {
            System.out.println("No task found...");
        }
    }
}