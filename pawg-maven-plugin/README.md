# How to use it in the project?

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