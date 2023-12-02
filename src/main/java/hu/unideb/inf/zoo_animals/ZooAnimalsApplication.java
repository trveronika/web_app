package hu.unideb.inf.zoo_animals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("hu.unideb.inf.zoo_animals.service.mapper")
@SpringBootApplication
public class ZooAnimalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooAnimalsApplication.class, args);
    }

}
