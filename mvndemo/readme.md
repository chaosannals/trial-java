# mvn demo

## 常用命令

```bash
# 创建原型项目
mvn archetype:generate -DgroupId={project-packaging} -DartifactId={project-name} -DarchetypeArtifactId={maven-template}  -DinteractiveMode=false

# 查找本地已有模板库
mvn archetype:generate -Dfilter=org.springframework.boot

# 示例，maven-archetype-quickstart是一个模板库
mvn archetype:generate -DgroupId=com.chaosannals -DartifactId=simpledemo -DarchetypeArtifactId=maven-archetype-quickstart  -DinteractiveMode=false

# 示例，spring boot 命令模板 这个模板有问题
mvn archetype:generate -DgroupId=com.chaosannals -DartifactId=sbsimpledemo -DarchetypeGroupId=org.springframework.boot -DarchetypeArtifactId=spring-boot-sample-simple-archetype  -DinteractiveMode=false

# 编译 *.java 到 *.class 文件
mvn compile

# 执行 指定主类名
mvn exec:java -Dexec.mainClass="com.chaosannals.App"

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
