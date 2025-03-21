package astkach.todotest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author artem
 */
public class TaskManager {
    private List<Task> tasks;
    private int nextId;
    
    public TaskManager() {
        tasks = new ArrayList<>();
        nextId = 1;
    }
    
    public void addTask(String description) {
        Task task = new Task(nextId, description);
        tasks.add(task);
        nextId++;
    }
    
    public boolean deleteTask(int id) {
        Optional<Task> taskToRemove = tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
        if (taskToRemove.isPresent()) {
            tasks.remove(taskToRemove.get());
            return true;
        }
        return false;
    }
    
    public boolean markTaskAsCompleted(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.setIsCompleted(true);
                return true;
            }
        }
        return false;
    }
    
    public void printAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Tasks not found, create them first");
            return;
        }
        
        for (Task task : tasks) {
            String status = task.isCompleted() ? "[DONE]" : "[CREATED]";
            
            System.out.printf("%d. %s %s%n",
                    task.getId(),
                    status,
                    task.getDescription()
            );
        }
    }
    
    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Task task : tasks) {
                String line  = String.format("%d, %s, %b%n",
                            task.getId(),
                            task.getDescription(),
                            task.isCompleted()
                        );
                writer.write(line);
            }
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }
    
    public void loadFromFile(String filename) {
        tasks.clear();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String description = parts[1];
                boolean isCompleted = Boolean.parseBoolean(parts[2]);

                Task task = new Task(id, description);
                task.setIsCompleted(isCompleted);
                tasks.add(task);
            }
            nextId = tasks.isEmpty() ? 1 : tasks.get(tasks.size() - 1).getId() + 1;
        } catch (IOException e) {
            System.err.println("Error loading from file: " + e.getMessage());
        }
    }
}
