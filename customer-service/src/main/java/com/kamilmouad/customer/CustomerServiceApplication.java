package com.kamilmouad.customer;

import com.kamilmouad.customer.entities.Customer;
import com.kamilmouad.customer.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.saveAll(List.of(
                    Customer.builder().name("Mouad").email("maro@gmail.com").build(),
                    Customer.builder().name("kamil").email("kml@gmail.com").build(),
                    Customer.builder().name("jaafar").email("jaafar@gmail.com").build()
            ));
            customerRepository.findAll().forEach(System.out::println);
        };
    }
}
