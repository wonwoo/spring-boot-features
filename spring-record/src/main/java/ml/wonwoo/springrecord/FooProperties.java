package ml.wonwoo.springrecord;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("sample")
@ConstructorBinding
record FooProperties(String name, int age) {}
