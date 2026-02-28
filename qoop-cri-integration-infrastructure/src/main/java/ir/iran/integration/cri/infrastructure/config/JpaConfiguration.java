package ir.iran.integration.cri.infrastructure.config;


import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "ir.iran.integration.cri.infrastructure.persistence.repository.jpa.spring")
@EntityScan("ir.iran.integration.cri.infrastructure.persistence.repository.jpa.entity")
public class JpaConfiguration {
}
