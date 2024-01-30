package com.szymix;

import com.szymix.customer.Customer;
import com.szymix.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            Customer alex = new Customer("Alex", "alex@gmail.com", 21);
            Customer anna = new Customer("Anna", "anna@gmail.com", 19);
            customerRepository.save(alex);
            customerRepository.save(anna);

        };
    }
}
