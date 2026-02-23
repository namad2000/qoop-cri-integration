package ir.iran.integration.cri.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ir.online.integration.sms")
public class CriApplication {

    public static void main(String[] args) {
        SpringApplication.run(CriApplication.class, args);
    }
}
