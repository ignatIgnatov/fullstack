package com.example.restapi.web;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import com.example.restapi.model.ContactMessageEntity;
import com.example.restapi.model.UserEntity;
import com.example.restapi.repository.ContactMessageRepository;
import com.example.restapi.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ContactMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @Autowired
    private UserRepository userRepository;

    private UserEntity testUser;

    @BeforeEach
    void setup() {
        testUser = new UserEntity();
        testUser.setPassword("password")
                .setUsername("username")
                .setEmail("user@email.com");

        testUser = userRepository.save(testUser);
    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
        contactMessageRepository.deleteAll();
    }

    @Test
    void getMessage() throws Exception {
        ContactMessageEntity message1 = createMessage();
        ContactMessageEntity message2 = createMessage();

        mockMvc.perform(get("/message/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.[0].authorName", is(testUser.getUsername())))
                .andExpect(jsonPath("$.[0].email", is(testUser.getEmail())))
                .andExpect(jsonPath("$.[0].message", is("this is message")))
                .andExpect(jsonPath("$.[1].authorName", is(testUser.getUsername())))
                .andExpect(jsonPath("$.[1].email", is(testUser.getEmail())))
                .andExpect(jsonPath("$.[1].message", is("this is message")));

    }


    private ContactMessageEntity createMessage() {
        ContactMessageEntity testMessage = new ContactMessageEntity();
        testMessage.setAuthorName(testUser.getUsername())
                .setEmail(testUser.getEmail())
                .setMessage("this is message");

     testMessage = contactMessageRepository.save(testMessage);
     return testMessage;
    }

}