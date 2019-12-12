package com.example.movieunitandintegrationtests;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("classpath:application.properties")
@ContextConfiguration(classes = IntegrationTestContextConfiguration.class)
public abstract class BaseIntegrationTest {
}