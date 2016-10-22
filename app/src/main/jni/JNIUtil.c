#include <jni.h>
#include"com_yanyuanquan_ndkdemo_JNIUtil.h"


/*
 * Class:     com_yanyuanquan_ndkdemo_JNIUtil
 * Method:    getString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_yanyuanquan_ndkdemo_JNIUtil_getString
        (JNIEnv *env, jobject obj) {

    return (*env)->NewStringUTF(env, "Hello World!");

}

JNIEXPORT jintArray JNICALL Java_com_yanyuanquan_ndkdemo_JNIUtil_getBitmapByNDK
        (JNIEnv *env, jclass clz, jintArray buffer, jint width, jint height) {
    int arr = (*env)->CallIntMethod(env, clz, buffer, 0);

    return (*env)->GetIntArrayElements(env, buffer, 0);
}