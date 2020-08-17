package ml.wonwoo.propertiesname;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.boot.context.properties.bind.Name;

@ConstructorBinding
@ConfigurationProperties("sample")
public class SampleProperties {

    private final String clazz;

    public SampleProperties(@Name("class") String clazz) {
        this.clazz = clazz;
    }

    public String getClazz() {
        return clazz;
    }
}
