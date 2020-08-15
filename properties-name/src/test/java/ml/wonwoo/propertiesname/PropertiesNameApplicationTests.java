package ml.wonwoo.propertiesname;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PropertiesNameApplicationTests {

    private final SampleProperties sampleProperties;

    @Autowired
    PropertiesNameApplicationTests(SampleProperties sampleProperties) {
        this.sampleProperties = sampleProperties;
    }

    @Test
    void contextLoads() {
        assertThat(sampleProperties.getIndex()).isEqualTo("wonwoo");
    }
}
