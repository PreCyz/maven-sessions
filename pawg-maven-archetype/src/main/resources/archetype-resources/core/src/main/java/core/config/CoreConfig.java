package ${package}.core.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableConfigurationProperties
@Slf4j
public class CoreConfig {

    @PostConstruct
    void init() {
        log.info("CoreConfig read.");
    }

}
