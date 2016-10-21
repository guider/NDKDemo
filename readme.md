## NDK开发笔记


### 写在前面：
 * 创建项目 不能勾选 include c++ 血泪教训
 * 保证本地的NDK环境已经搭建完成，随便执行$ ndk-build  一般只要不报找不到命定都是可以的

###Step

1. 新建一个项目，创建一个Java类，JNIUtil.java






在项目的 gradle.properties 文件的末尾添加如下代码：android.useDeprecatedNdk=true解决ndk提示版本低不能自动编译jn
















[参考1](http://blog.csdn.net/u011368551/article/details/50897874)
[参考2](http://blog.csdn.net/u014702999/article/details/52626318)