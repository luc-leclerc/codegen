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

# Mustache convention

## Case Style
* CC: camelCase
* PC: PascalCase
* SC: snake_case
* KC: kebab-case
* DC: dot.case


# Ref
https://swagger.io/specification