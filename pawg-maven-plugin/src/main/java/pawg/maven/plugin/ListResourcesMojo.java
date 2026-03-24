package pawg.maven.plugin;

import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

// Annotation @Mojo defines the name fo the goal and default phase
@Mojo(name = "list-resources", defaultPhase = LifecyclePhase.VALIDATE)
public class ListResourcesMojo extends AbstractMojo {

    // Maven project object Injection -> access to the configuration of the build
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("-------------------------------------------------------");
        getLog().info(" LISTING RESOURCES FOR MODULE: " + project.getArtifactId());
        getLog().info("-------------------------------------------------------");

        List<Resource> resources = project.getResources();

        if (resources.isEmpty()) {
            getLog().info("No resources found.");
            return;
        }

        for (Resource resource : resources) {
            String directory = resource.getDirectory();
            Path dirPath = Paths.get(directory);

            if (Files.exists(dirPath) && Files.isDirectory(dirPath)) {
                getLog().info("Source directory: " + directory);
                try (Stream<Path> paths = Files.walk(dirPath)) {
                    paths.filter(Files::isRegularFile)
                         .forEach(path -> {
                             // Wyświetlamy ścieżkę względną pliku w folderze resources
                             String relativePath = dirPath.relativize(path).toString();
                             getLog().info("  -> " + relativePath);
                         });
                } catch (IOException e) {
                    throw new MojoExecutionException("Error reading resource directory: " + directory, e);
                }
            } else {
                getLog().warn("Resource directory defined but not found: " + directory);
            }
        }
        getLog().info("-------------------------------------------------------");
    }
}
