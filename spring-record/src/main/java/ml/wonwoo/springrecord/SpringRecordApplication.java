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
            String insert = """
                    insert into 
                    customer(name, age) 
                    values(?,?)
                    """;
            jdbcTemplate.update(insert, "wonwoo", 20);
            jdbcTemplate.update(insert, "fidel", 14);
            String select = """
                    select 
                        * 
                    from 
                        customer
                    """;
            List<Customer> customers = jdbcTemplate.query(select, new DataClassRowMapper<>(Customer.class));
            System.out.println(customers);
        };
    }
}
