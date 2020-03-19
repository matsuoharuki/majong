package majong.ml;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.AreaAveragingScaleFilter;
import java.awt.image.FilteredImageSource;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageConverter {

    public static void resizeImage(File in, File out, double scale) throws IOException {
        BufferedImage org = ImageIO.read(in);
        ImageFilter filter = new AreaAveragingScaleFilter(
            (int)(org.getWidth() * scale), (int)(org.getHeight() * scale));
        ImageProducer p = new FilteredImageSource(org.getSource(), filter);
        Image dstImage = Toolkit.getDefaultToolkit().createImage(p);
        BufferedImage dst = new BufferedImage(
            dstImage.getWidth(null), dstImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = dst.createGraphics();
        g.drawImage(dstImage, 0, 0, null);
        g.dispose();
        ImageIO.write(dst, "png", out); 
    }

    public static void changeImageColor(File in, File out) throws IOException {
        BufferedImage org = ImageIO.read(in);
        ImageFilter filter = new ThreeValueImageFilter();
        ImageProducer p = new FilteredImageSource(org.getSource(), filter);
        Image dstImage = Toolkit.getDefaultToolkit().createImage(p);
        BufferedImage dst = new BufferedImage(
            dstImage.getWidth(null), dstImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = dst.createGraphics();
        g.drawImage(dstImage, 0, 0, null);
        g.dispose();
        ImageIO.write(dst, "png", out); 
    }


}

