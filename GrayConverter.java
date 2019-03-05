
/**
 * Write a description of class GrayConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
public class GrayConverter {

    public void  makeImageGray (){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
        ImageResource colorImage = new ImageResource(f);
        ImageResource grayImage = new ImageResource(colorImage.getWidth(), colorImage.getHeight());
        for (Pixel pixel : grayImage.pixels()){
            Pixel colorPixel = colorImage.getPixel(pixel.getX(), pixel.getY());
            int average = (colorPixel.getRed() + colorPixel.getGreen() + colorPixel.getBlue())/3;
            pixel.setRed(average);
            pixel.setGreen(average);
            pixel.setBlue(average);
        }
        String fname = colorImage.getFileName();
        String newName = "gray-" + fname;
        grayImage.setFileName(newName);
        grayImage.draw();
        grayImage.save();
    }
}
}
