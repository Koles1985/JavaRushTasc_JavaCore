/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javarush.tasks.java_core.level_6.task_20_factory_method_pattern;

import javarush.tasks.java_core.level_6.task_20_factory_method_pattern.common.BmpReader;
import javarush.tasks.java_core.level_6.task_20_factory_method_pattern.common.JpgReader;
import javarush.tasks.java_core.level_6.task_20_factory_method_pattern.common.PngReader;

/**
 *
 * @author User
 */
public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes imageTypes)
            throws IllegalArgumentException{
        switch(imageTypes){
            case BMP:
                return new BmpReader();
            case JPG:
                return new JpgReader();
            case PNG:
                return new PngReader(); 
                
            default:
                throw new IllegalArgumentException("Неизвестный тип картинки");
        }
   
    }
}
