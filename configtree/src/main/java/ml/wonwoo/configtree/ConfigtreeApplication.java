package ml.wonwoo.configtree;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ConfigtreeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigtreeApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(FooProperties properties) {
        return args -> System.out.println(properties.getName());
    }
}
