package ml.wonwoo.r2dbctemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.r2dbc.DataR2dbcTest;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@DataR2dbcTest
class R2dbcTemplateApplicationTests {

    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    @Autowired
    R2dbcTemplateApplicationTests(R2dbcEntityTemplate r2dbcEntityTemplate) {
        this.r2dbcEntityTemplate = r2dbcEntityTemplate;
    }

    @Test
    void customer_test() {

        Customer customer = new Customer();
        customer.setAddress("Seongnam-si, Gyeonggi-do, Republic of Korea");
        customer.setName("wonwoo");
        Flux<Customer> customerFlux = r2dbcEntityTemplate.insert(customer)
                .thenMany(r2dbcEntityTemplate.select(Query.empty(), Customer.class));

        StepVerifier.create(customerFlux)
                .assertNext(it -> {
                    assertThat(it.getName()).isEqualTo("wonwoo");
                    assertThat(it.getAddress()).isEqualTo("Seongnam-si, Gyeonggi-do, Republic of Korea");
                }).verifyComplete();
    }

}
