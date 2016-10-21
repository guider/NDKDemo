package com.yanyuanquan.ndkdemo;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

/**
 * Created by apple on 16/10/22.
 */

public class ImgaeUtil {
    public static Bitmap getBitmapByJava(Bitmap bitmap) {

        float brightness = 1.5f;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap resultBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int pixel = bitmap.getPixel(i, j);

                int a = Color.alpha(pixel);
                int r = Color.red(pixel);
                int g = Color.green(pixel);
                int b = Color.blue(pixel);
                Log.e("zjw", "  r   " + r + "    g  " + g + "   b   " + b);

                r = r * brightness > 255 ? 255 : (int) (r * brightness);
                g = g * brightness > 255 ? 255 : (int) (g * brightness);
                b = b * brightness > 255 ? 255 : (int) (b * brightness);
                Log.e("zjw", "  r   " + r + "    g  " + g + "   b   " + b);
                int resultPiexl = Color.argb(a, r, g, b);
                resultBitmap.setPixel(i, j, resultPiexl);
            }
        }
        return resultBitmap;
    }


}
