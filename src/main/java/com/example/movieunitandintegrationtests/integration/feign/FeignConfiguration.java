package com.example.movieunitandintegrationtests.integration.feign;

import com.example.movieunitandintegrationtests.integration.OmdbApi;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    @Value("${integration.omdb.api}")
    private String omdbUrl;

    @Bean
    @Qualifier("omdbApi")
    public OmdbApi omdbApiFeign() {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(OmdbApi.class, omdbUrl);
    }
}
