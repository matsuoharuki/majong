package majong.ml;
import java.awt.image.RGBImageFilter;


public class ThreeValueImageFilter extends RGBImageFilter {
    @Override
    public int filterRGB(int x, int y, int rgb) {
        System.out.println("----------");
        System.out.println((int)(rgb >> 16 & 0xff));
        System.out.println((int)(rgb >> 8 & 0xff));
        System.out.println((int)(rgb & 0xff));
        return rgb;
    }

}