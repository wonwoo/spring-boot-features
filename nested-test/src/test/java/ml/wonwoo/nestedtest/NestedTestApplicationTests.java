package ml.wonwoo.nestedtest;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.NestedTestConfiguration;
import org.springframework.test.context.TestConstructor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.TestConstructor.AutowireMode.ALL;

@SpringBootTest
@TestConstructor(autowireMode = ALL)
class NestedTestApplicationTests {

    @Nested
    @NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.OVERRIDE)
    @TestConstructor(autowireMode = ALL)
    @SpringBootTest
    class OverrideGreetings {

        OverrideGreetings(HelloService helloService) {
            assertThat(helloService.hello()).isEqualTo("hello world");
        }

        @Test
        void hello() {
        }
    }

    @Nested
    @NestedTestConfiguration(NestedTestConfiguration.EnclosingConfiguration.INHERIT)
    class InheritGreetings {

        InheritGreetings(HelloService helloService) {
            assertThat(helloService.hello()).isEqualTo("hello world");
        }

        @Test
        void hello() {
        }
    }

    @Nested
    class DefaultGreetings {

        DefaultGreetings(HelloService helloService) {
            assertThat(helloService.hello()).isEqualTo("hello world");
        }

        @Test
        void hello() {
        }
    }
}
