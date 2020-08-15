package com.example.propertiesyml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.Name;

@ConstructorBinding
@ConfigurationProperties("sample")
public class SampleProperties {

    private final String index;

    public SampleProperties(@Name("name") String index) {
        this.index = index;
    }

    public String getIndex() {
        return index;
    }
}
