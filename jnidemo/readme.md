# jni

```bash
# 一般如果由 gradle 编译不需要这步，这个仅生成 class 文件
javac src/main/java/trial/java/jnidemo/JniUtil.java -d build/classes/java/main

# 生成头文件
javah -cp build/classes/java/main trial.java.jnidemo.JniUtil

# 高版本 jdk 没有 javah 使用 javac -h 
javac -h src/main/c src/main/java/trial/java/jnidemo/JniUtil.java

# 通过生成 头文件的声明，去写实现。编译的 动态链接库 可以被java 加载。
```
