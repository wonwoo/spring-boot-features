package ml.wonwoo.startup;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.metrics.buffering.BufferingApplicationStartup;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class StartupApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(StartupApplication.class)
                .applicationStartup(new BufferingApplicationStartup(1024))
                .build()
                .run(args);
    }

    @Bean
    SomeService someService() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(2000);
        return new SomeService();
    }
}
