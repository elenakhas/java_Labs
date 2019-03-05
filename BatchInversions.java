
/**
 * Write a description of class BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.File;
public class BatchInversions {
    public ImageResource makeinversion(ImageResource inImage){
        ImageResource invertedImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : invertedImage.pixels()){
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int newRed = 255 - inPixel.getRed();
            int newGreen = 255 - inPixel.getGreen();
            int newBlue = 255 - inPixel.getBlue();
            pixel.setRed(newRed);
            pixel.setGreen(newGreen);
            pixel.setBlue(newBlue);
        }
        return invertedImage;
    }

    
    public void selectAndConvert(){
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            ImageResource image = new ImageResource(f);
            ImageResource newimage = makeinversion(image);
            newimage.draw();
            String filename = image.getFileName();
            String newname = "inverted-" + filename;
            newimage.setFileName(newname);
            newimage.save();
            newimage.draw();
        }
    }
}
