## NDK开发笔记


### 写在前面：
 * 创建项目 不能勾选 include c++ 血泪教训
 * 保证本地的NDK环境已经搭建完成，随便执行$ ndk-build  一般只要不报找不到命定都是可以的

###Step  无脑式教程送上

1. 新建一个项目，创建一个Java类，JNIUtil.java
[](https://github.com/guider/NDKDemo/blob/master/images/newclass.png)

2. buildProject  此时在app/build/intermediates/classes/{包名}/JNIUtil.class


3. 通过javah 命令生成JNIUtil对应的头文件 ，打开terminal  进入app/build/intermediates/classes/执行 javah -jni {包名}JNIUtil
    此时在 app/build/intermediates/classes/ 会生成一个对应的.h 文件

4.app/src/main 下创建一个文件夹 jni  并把 刚刚生成的.h文件移动过去，同时在此文件夹下面创建一个JNIUtil.c的文件
 在文件中include 之前的头文件， 并且实现 头文件的方法。


5. 接下来在app module目录下的build.gradle中设置库文件名（生成的so文件名）。找到gradle文件的defaultConfig这项，在里面添加如下内容：


6. so生成完成即可使用 ，通过  以下方式引入 即可调用方法了

    >static{
        System.loadLibrary("libLib");// 你的so文件名字。
    }
7. 在项目的 gradle.properties 文件的末尾添加如下代码：解决ndk提示版本低不能自动编译jni


   > android.useDeprecatedNdk=true
   最后编译运行。

















[参考1](http://blog.csdn.net/u011368551/article/details/50897874)
[参考2](http://blog.csdn.net/u014702999/article/details/52626318)