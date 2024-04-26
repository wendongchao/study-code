# Maven项目构建

【Maven命令的作用】https://blog.csdn.net/qq_32332777/article/details/109067174

项目启动加载配置文件信息

aop切面加载

白名单的作用

Maven中每个模块的作用

ruoyi注解实用细节

```xml
<plugins>
            <!--Maven编译-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <encoding>UTF-8</encoding>
                </configuration>
            </plugin>
            <!--Maven打jar-->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-jar-plugin</artifactId>
                <configuration>
                    <archive>
                        <addMavenDescriptor>false</addMavenDescriptor>
                        <index>true</index>
                        <manifest>
                            <addDefaultSpecificationEntries>true</addDefaultSpecificationEntries>
                            <addDefaultImplementationEntries>true</addDefaultImplementationEntries>
                        </manifest>
                        <manifestEntries>
                            <Implementation-Build>${maven.build.timestamp}</Implementation-Build>
                        </manifestEntries>
                    </archive>
                </configuration>
            </plugin>
        </plugins>
```

```
这段XML代码是Maven项目中的插件配置。Maven插件是Maven的一部分，用于执行项目构建过程中的特定任务。这段代码定义了两个插件：`maven-compiler-plugin`和`maven-jar-plugin`。

1. `maven-compiler-plugin`：这个插件用于编译Java代码。它的配置包括：
   - `source`：指定编译的Java版本，这里是1.8。
   - `target`：指定编译的目标Java版本，这里是1.8。
   - `encoding`：指定编码，这里是UTF-8。
2. `maven-jar-plugin`：这个插件用于生成JAR（Java库）文件。它的配置包括：
   - `archive`：定义生成的JAR文件的属性，包括：
     - `addMavenDescriptor`：是否添加Maven描述符，这里是false。
     - `index`：是否生成索引文件，这里是true。
     - `manifest`：包含JAR文件中的MANIFEST.MF属性，包括：
       - `addDefaultSpecificationEntries`：是否添加默认的规范条目，这里是true。
       - `addDefaultImplementationEntries`：是否添加默认的实现条目，这里是true。
     - `manifestEntries`：自定义MANIFEST.MF中的条目，这里是：
       - `Implementation-Build`：实现构建时间戳。

这些插件的配置用于控制Maven项目构建过程，以确保生成的JAR文件符合项目的构建要求。