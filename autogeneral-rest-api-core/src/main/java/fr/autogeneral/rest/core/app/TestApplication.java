package fr.autogeneral.rest.core.app;

import java.util.Stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Shankar on 03/03/2017.
 */
@ComponentScan(basePackages="fr.autogeneral.rest.api")
@EntityScan(basePackages="fr.autogeneral.rest.core.model")
@EnableJpaRepositories(basePackages="fr.autogeneral.rest.core.dao")
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TestApplication.class, args);
    }
    

}

