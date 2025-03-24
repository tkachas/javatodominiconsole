/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package astkach.todotest;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author artem
 */
public class Todotest {
    
    public static void main(String[] args) throws IOException {
        TaskManager manager = new TaskManager();
        
        Scanner scanner = new Scanner(System.in);
        MenuHandler menuHandler = new MenuHandler(manager, scanner);
        
        while(true) {
            System.out.println("\n--- To-Do List Manager ---");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Отметить как выполненную");
            System.out.println("4. Показать все задачи");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Загрузить из файла");
            System.out.println("7. Получить задачу по id");
            System.out.println("8. Выйти");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1 -> menuHandler.addTask();
                    case 2 -> menuHandler.deleteTask();
                    case 3 -> menuHandler.markTaskAsCompleted();
                    case 4 -> menuHandler.printAllTasks();
                    case 5 -> menuHandler.saveToFile();
                    case 6 -> menuHandler.loadFromFile();
                    case 7 -> menuHandler.getTaskById();
                    case 8 -> {
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("No such option");
                }
            } catch (IOException e) {
                System.err.println("File error: " + e.getMessage());
            }
        }
    }
}
