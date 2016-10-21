package com.yanyuanquan.ndkdemo;


public class JNIUtil  {

    public native String getString();
    public static native int[] getBitmapByNDK(int[] buffer, int width, int height);

}
