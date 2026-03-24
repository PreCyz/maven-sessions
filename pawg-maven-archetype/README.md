### Archetype creates a module that follows hexagonal principles.

Build it with `mvn clean install`.

Use it by executing below command in PowerShell. Adjust it to bash or cmd.

```powershell
mvn archetype:generate `
    "-DarchetypeGroupId=pawg.maven.archetypes" `
    "-DarchetypeArtifactId=pawg-maven-archetyp" `
    "-DarchetypeVersion=1.0.0-SNAPSHOT" `
    "-DgroupId=pawg.hexagonal.seminar" `
    "-DartifactId=hex-modulo" `
    "-Dversion=1.0.0-SNAPSHOT" `
    "-DinteractiveMode=false" `
    "-DapplicationDescription=Hexagonal module generated from maven archetype."
```