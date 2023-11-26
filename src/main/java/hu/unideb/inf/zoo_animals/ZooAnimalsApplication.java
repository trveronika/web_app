package hu.unideb.inf.zoo_animals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "hu.unideb.inf.zoo_animals.service.mapper")
public class ZooAnimalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZooAnimalsApplication.class, args);
    }

}
