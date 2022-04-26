/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_32_sequential_output_of_files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author User
 */
public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    
    private static volatile BufferedReader reader;
    
    static{
        try{
            if(reader == null){
                reader = new BufferedReader(
                        new InputStreamReader(System.in));
                firstFileName = reader.readLine();
                secondFileName = reader.readLine();
            }   
        }catch(IOException e){
            System.out.println(e.getMessage());
        }finally{
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public Solution(){
        try {
            systemOutPrintln(firstFileName);
            systemOutPrintln(secondFileName);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }      
    }
    
    /**
     *
     * @param fileName
     * @throws InterruptedException
     */
    public void systemOutPrintln(String fileName) throws InterruptedException{
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }
    
    public interface ReadFileInterface{
        void setFileName(String fullFileName);
        String getFileContent();
        void join() throws InterruptedException;
        void start();
    }
    
    public class ReadFileThread implements Runnable, ReadFileInterface{ // можно и наследовать от Thread
        private String fileName;
        private String fileContent;
        private Thread t = new Thread(this);
        @Override
        public void run() {
            StringBuilder fileText = new StringBuilder();

            try {
                FileReader fileReader = new FileReader(fileName);
                reader = new BufferedReader(fileReader);
                while (reader.ready()) {
                    fileText.append(reader.readLine() + "\n");
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            
            this.fileContent = fileText.toString();
            
        }
        

        @Override
        public void setFileName(String fullFileName) {
            if(fullFileName != null){
                this.fileName = fullFileName;
            }else{
                System.out.println("Enter file name!");
            }
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void join() throws InterruptedException {
            t.join();
        }

        @Override
        public void start() {
            t.start();
        }
        
    }
    
}
