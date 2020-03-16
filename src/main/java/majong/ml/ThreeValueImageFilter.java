package majong.ml;
import java.awt.image.RGBImageFilter;


public class ThreeValueImageFilter extends RGBImageFilter {
    @Override
    public int filterRGB(int x, int y, int rgb) {
        int r = (int)(rgb >> 16 & 0xff);
        int g = (int)(rgb >> 8 & 0xff);
        int b = (int)(rgb & 0xff);
        int newColor = rgb;
        if ((r + g + b) / 3 > 100) {
            newColor = 0xffffffff;
        }
        else if(r - (g + b) / 2 > 10){
            newColor = 0xffff0000;
        }
        else {
            newColor = 0xff000000;
        }

        return newColor;
    }

}