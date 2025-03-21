/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package astkach.todotest;

import java.util.Scanner;

/**
 *
 * @author artem
 */
public class Todotest {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Отметить как выполненную");
            System.out.println("4. Показать все задачи");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Загрузить из файла");
            System.out.println("7. Выход");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> {
                    System.out.println("Input task description: ");
                    String description = scanner.nextLine();
                    manager.addTask(description);
                    System.out.println("Task added...");
                }
                case 2 -> {
                    System.out.println("Input task id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (manager.deleteTask(id)) {
                        System.out.println("Task deleted");
                    } else {
                        System.out.println("Task not found. ID - " + id);
                    }
                }
                case 3 -> {
                    System.out.println("Input task id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    if (manager.markTaskAsCompleted(id)) {
                        System.out.println("\u001B[32mTask completed\u001B[0m");
                    } else {
                        System.out.println("Task not found. ID - " + id);
                    }
                }
                case 4 -> manager.printAllTasks();
                case 5 -> {
                 System.out.println("Enter file name: ");
                 String filename = scanner.nextLine();
                 manager.saveToFile(filename);
                }
                case 6 -> {
                    System.out.println("Enter file name: ");
                    String filename = scanner.nextLine();
                    manager.loadFromFile(filename);
                }
                case 7 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("No such option");
            }
        }
    }
}
