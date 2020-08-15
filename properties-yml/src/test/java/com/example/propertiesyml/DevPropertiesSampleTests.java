package com.example.propertiesyml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("dev")
@SpringBootTest
public class DevPropertiesSampleTests {

    private final SampleProperties sampleProperties;

    @Autowired
    DevPropertiesSampleTests(SampleProperties sampleProperties) {
        this.sampleProperties = sampleProperties;
    }

    @Test
    void contextLoads() {
        assertThat(sampleProperties.getIndex()).isEqualTo("fidel");
    }

}
