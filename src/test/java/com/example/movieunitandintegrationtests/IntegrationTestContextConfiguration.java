package com.example.movieunitandintegrationtests;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.example.movieunitandintegrationtests.integration")
@ComponentScan("com.example.movieunitandintegrationtests.service")
public class IntegrationTestContextConfiguration {
}
