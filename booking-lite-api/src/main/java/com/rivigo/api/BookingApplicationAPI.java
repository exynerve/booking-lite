package com.rivigo.api;

import com.rivigo.service.BookingConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = {"com.rivigo.service", "com.rivigo.api"})
@Import(BookingConfiguration.class)
public class BookingApplicationAPI {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplicationAPI.class, args);
    }
}
