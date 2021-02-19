package ml.wonwoo.springrecord;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
@ConfigurationPropertiesScan
public class SpringRecordApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRecordApplication.class, args);
    }

    @Bean
    CommandLineRunner initProperties(FooProperties properties) {
        return args -> {
            System.out.println(properties.name());
            System.out.println(properties.age());
        };
    }

    @Bean
    CommandLineRunner jdbc(JdbcTemplate jdbcTemplate) {
        return args -> {
            String sql = """
                    insert into 
                    customer(name, age) 
                    values(?,?)
                    """;
            jdbcTemplate.update(sql, "wonwoo", 20);
            jdbcTemplate.update(sql, "fidel", 14);
            List<Customer> customers = jdbcTemplate.query("select * from customer", new DataClassRowMapper<>(Customer.class));
            System.out.println(customers);
        };
    }
}
