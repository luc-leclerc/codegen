# codegen

# How to use
1. Run `mvn install` to install plugin locally.
2. Add the plugin in your project's build step, ex.:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>com.lleclerc</groupId>
            <artifactId>codegen</artifactId>
            <version>1.0-SNAPSHOT</version>
            <executions>
                <execution>
                    <configuration>
                        <swaggerFilePath>${project.basedir}/swagger.yml</swaggerFilePath>
                    </configuration>
                    <goals>
                        <goal>generate-sources</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
    </plugins>
</build>
```
3. Run `mvn generate-sources`


# Technical decision 

* This project is a tool to generate boilerplate code to support a simple API.
  * `a simple API` Default value won't be supported.
  * `a simple API` Required value won't be supported.
  * `a simple API` Inner Object/Enum not directly under `schemas` won't be supported. A single namespace allowed. 

# Development

* `mvn generate-resources` to refresh templates

# References
* [swagger spec](https://swagger.io/specification)