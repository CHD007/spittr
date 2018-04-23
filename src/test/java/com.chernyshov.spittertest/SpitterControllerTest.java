package com.chernyshov.spittertest;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;
import spitter.Spitter;
import spitter.data.SpitterRepository;
import spitter.web.SpitterController;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpitterControllerTest {

    @Test
    public void shouldShowRegisterForm() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));

    }

    @Test(expected = NestedServletException.class)
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
                .param("password", "24hours")
                .param("profilePicture", ""))
            .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(repository, atLeastOnce()).save(unsavedSpitter);
    }

    @Test
    public void shouldShowSpitterProfile() throws Exception {
        SpitterRepository spitterRepository = mock(SpitterRepository.class);

        Spitter savedSpitter = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");

        when(spitterRepository.findByUserName("jbauer")).thenReturn(savedSpitter);

        SpitterController spitterController = new SpitterController(spitterRepository);
        MockMvc mockMvc = standaloneSetup(spitterController).build();

        mockMvc.perform(get("/spitter/jbauer"))
                .andExpect(model().attribute("spitter", savedSpitter))
                .andExpect(view().name("profile"));
    }
}
