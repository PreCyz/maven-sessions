### Custom maven plugin lists all resources defined in module.
First build it with `mvn clean install`.

### How to use it in the project?

Add below configuration to the module's `pom.xml`.

```xml
<build>
  <plugins>
    <plugin>
      <groupId>pawg.maven</groupId>
      <artifactId>pawg-maven-plugin</artifactId>
      <version>1.0.0-SNAPSHOT</version>

      <configuration>
        <headerText>=== RESOURCES TITLE ===</headerText>
      </configuration>
      <executions>
        <execution>
          <goals>
            <goal>list-resources</goal>
          </goals>
        </execution>
      </executions>
    </plugin>
  </plugins>
</build>
```