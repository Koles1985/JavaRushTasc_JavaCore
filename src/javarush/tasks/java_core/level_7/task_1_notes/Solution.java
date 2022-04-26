/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_7.task_1_notes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Koles
 */
public class Solution {
    
    public Solution(){
        new NoteThread().start();
        new NoteThread().start();
    }
    
    public class NoteThread extends Thread{
        
        @Override
        public void run(){
            try{
                for(int i = 0; i < 1000; i++){
                    Note.addNote(this.getName() + "-Note" + i);
                    this.sleep(1);
                    Note.removeNote(this.getName());
                }    
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public static class Note{
        public static final List<String> notes = new ArrayList<>();
        
        public static void addNote(String note){
            notes.add(0, note);
        }
        
        public static void removeNote(String threadName){
            String note = notes.remove(0);
            if(note == null){
                System.out.println("Другая нить удалила заметку!");
            }else if(!note.startsWith(threadName)){
                System.out.println("Нить [" + threadName + "] удалила " +
                        "чужую заметку [" + note + "]");
            }else{
                System.out.println("Нить [" + threadName + "] удалила " +
                        "свою заметку [" + note + "]");
            }
        }
    }
    
}
