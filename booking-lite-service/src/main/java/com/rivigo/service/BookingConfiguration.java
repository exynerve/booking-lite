package com.rivigo.service;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan("com.rivigo.service.*")
@EnableJpaRepositories("com.rivigo.service.dao")
@EntityScan("com.rivigo.service.entity")
public class BookingConfiguration {
}
