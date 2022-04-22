/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_20_factory_method_pattern;

/**
 *
 * @author User
 */
public class Solution {
    
    public Solution(){
        ImageReader reader = ImageReaderFactory.getImageReader(ImageTypes.JPG);
    }
    
}
