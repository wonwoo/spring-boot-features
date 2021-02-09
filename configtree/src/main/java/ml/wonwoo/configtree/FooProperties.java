package ml.wonwoo.configtree;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConfigurationProperties("foo")
@ConstructorBinding
public class FooProperties {

    private final String name;

    public FooProperties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
