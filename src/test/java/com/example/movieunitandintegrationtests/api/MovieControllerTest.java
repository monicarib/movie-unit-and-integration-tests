package com.example.movieunitandintegrationtests.api;

import com.example.movieunitandintegrationtests.BaseIntegrationTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
@AutoConfigureWireMock(stubs = {"classpath:/stubs"})
public class MovieControllerTest extends BaseIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGettingMovieInformationByTitleAndTheMovieIsGoodShouldReturnIt() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                .queryParam("title", "The Green Mile"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recommended").value("true"));
    }

    @Test
    public void whenGettingMovieInformationByTitleAndTheMovieIsNotGoodShouldReturnIt() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/movies")
                .queryParam("title", "Lucy"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.recommended").value("false"));
    }
}