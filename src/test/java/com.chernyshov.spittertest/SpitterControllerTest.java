package com.chernyshov.spittertest;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spitter.Spitter;
import spitter.data.SpitterRepository;
import spitter.web.SpitterController;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegisterForm() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));

    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository repository = mock(SpitterRepository.class);

        Spitter unsavedSpitter = new Spitter("jbauer", "24hours", "Jack", "Bauer");
        Spitter savedSpitter = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");

        when(repository.save(unsavedSpitter)).thenReturn(savedSpitter);

        SpitterController spitterController = new SpitterController(repository);
        MockMvc mockMvc = standaloneSetup(spitterController).build();
        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("userName", "jbauer")
                .param("password", "24hours"))
            .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(repository, atLeastOnce()).save(unsavedSpitter);
    }
}
