#include"com_yanyuanquan_ndkdemo_JNIUtil.h"


/*
 * Class:     com_yanyuanquan_ndkdemo_JNIUtil
 * Method:    getString
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_yanyuanquan_ndkdemo_JNIUtil_getString
  (JNIEnv *env, jobject obj){

      return (*env)->NewStringUTF(env,"Hello World!");

  }