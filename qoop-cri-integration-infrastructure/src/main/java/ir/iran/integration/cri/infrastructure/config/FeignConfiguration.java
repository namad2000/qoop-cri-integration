package ir.iran.integration.cri.infrastructure.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("ir.iran.integration.cri.infrastructure.port.out.client.feign")
public class FeignConfiguration {
}
