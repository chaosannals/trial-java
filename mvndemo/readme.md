# mvn demo

## 常用命令

```bash
# 创建原型项目
mvn archetype:generate -DgroupId={project-packaging} -DartifactId={project-name} -DarchetypeArtifactId={maven-template}  -DinteractiveMode=false

# 查找本地已有模板库
mvn archetype:generate -Dfilter=org.springframework.boot

# 示例，maven-archetype-quickstart是一个模板库
mvn archetype:generate -DgroupId=com.chaosannals -DartifactId=simpledemo -DarchetypeArtifactId=maven-archetype-quickstart  -DinteractiveMode=false

# 示例，maven-archetype-quickstart是一个模板库
mvn archetype:generate -DgroupId=com.chaosannals -DartifactId=wardemo -DarchetypeArtifactId=maven-archetype-quickstart  -DinteractiveMode=false

# 示例， spring mvc 
mvn archetype:generate -DgroupId=com.chaosannals -DartifactId=smvcdemo -DarchetypeArtifactId=maven-archetype-quickstart  -DinteractiveMode=false

# 示例，spring boot 命令模板 这个模板有问题
mvn archetype:generate -DgroupId=com.chaosannals -DartifactId=sbsimpledemo -DarchetypeGroupId=org.springframework.boot -DarchetypeArtifactId=spring-boot-sample-simple-archetype  -DinteractiveMode=false

# 编译 *.java 到 *.class 文件
mvn compile

# 打印日志带 debug 级别
mvn compile -Djavax.net.debug=all exec:java -Dexec.mainClass="com.chaosannals.App" -Dmaven.test.skip=true

# 打包
mvn package -Dmaven.test.skip=true
# 清理打包
mvn clean package -Dmaven.test.skip=true

# 执行 指定主类名
mvn exec:java -Dexec.mainClass="com.chaosannals.App"

# 跳过单元测试，这个 simple 的单元测试模板有问题。
mvn exec:java -Dexec.mainClass="com.chaosannals.App" -Dmaven.test.skip=true

# 执行 指定 主类名 和 参数
mvn exec:java -Dexec.mainClass="com.chaosannals.App" -Dexec.args="argument1"

# 单元测试
mvn test

# spring boot 示例 run
mvn spring-boot:run
```

## WAR

### 通用 maven 打包 war 插件

### Apache 的 Maven 插件打包 war

#### maven-compiler-plugin

指定编译目标 JDK 版本编译参数等

```xml
<build>
    <plugins>
        <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.13.0</version>
        <configuration>
            <!-- put your configurations here -->
            <source>1.8</source>
            <target>1.8</target>
        </configuration>
        </plugin>

        <!-- war  -->
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-war-plugin</artifactId>
            <version>3.4.0</version>
        </plugin>
    </plugins>
</build>
```

### spring 的 maven 打包 war 插件

```xml

```

### spring boot 的 maven 打包 war 插件

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>3.3.0</version>
</dependency>
```


## 一些问题

阿里源

```xml
<repositories>
    <repository>
        <id>central</id>
        <url>https://maven.aliyun.com/repository/public</url>
        <layout>default</layout>
        <releases>
            <enabled>true</enabled>
        </releases>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</repositories>
```

```bash
# 查看 CA 证书
keytool -keystore -list
keytool -keystore "$JAVA_HOME\jre\lib\security\cacerts" -storepass changeit -list
keytool -keystore "$JAVA_HOME\jre\lib\security" -storepass changeit -list
```

mvn 在下载的时候报如下（一般这个年代还使用1.8基本都会遇到这个问题）：
```
the trustAnchors parameter must be non-empty
```
JDK 1.8 CA 证书太老，导致 mvn 下载失败，可以找 openjdk 下载最新的 11 ，它里面的带的 证书 就是最新的。然后复制过期，保留 security 目录下的 jar. 
openjdk11 是没有 jdk1.8 的 2 个 jar 的。直接复制文件夹会导致少了这 2个 jar.

https://www.ibm.com/docs/zh/jfsm/1.1.3.0?topic=port-modifying-jre-security-file



### jsp

taglib 这个 jstl 有问题。
tomcat 时好时坏的。

<%@ taglib uri="https://java.sun.com/jsp/jstl/core" prefix="c"%>
