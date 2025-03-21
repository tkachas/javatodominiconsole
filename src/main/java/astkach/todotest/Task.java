/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package astkach.todotest;

/**
 *
 * @author artem
 */
public class Task {
    private final int id;
    private String description;
    private boolean isCompleted;
    
    public Task(int id, String description) {
        this.id = id;
        this.description = description;
        this.isCompleted = false;
    }
    
    public int getId() {
        return id;
    }
    
    public String getDescription() {
        return description;
    } 
    
    public boolean isCompleted() {
        return isCompleted;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setIsCompleted(boolean completed) {
        this.isCompleted = completed;
    }
}
