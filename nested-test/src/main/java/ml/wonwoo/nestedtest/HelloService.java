package ml.wonwoo.nestedtest;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String hello() {
        return "hello world";
    }
}
