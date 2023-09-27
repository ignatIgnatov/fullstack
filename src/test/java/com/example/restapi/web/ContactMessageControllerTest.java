package com.example.restapi.web;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.restapi.model.ContactMessageEntity;
import com.example.restapi.model.UserEntity;
import com.example.restapi.model.dto.contactMessageDto.ContactMessageDto;
import com.example.restapi.repository.ContactMessageRepository;
import com.example.restapi.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

//@WithMockUser("ignat") -> logged user
@SpringBootTest
@AutoConfigureMockMvc
class ContactMessageControllerTest {

    private static final String CONTACT_MESSAGE_1 = "Hello world";
    private static final String CONTACT_MESSAGE_2 = "This is Java";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

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

    @Test
    void createComments() throws Exception {
        ContactMessageDto testMessageDto = new ContactMessageDto()
                .setMessage(CONTACT_MESSAGE_1);

        mockMvc.perform(
                post("/message/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testMessageDto))
                        .accept(MediaType.APPLICATION_JSON)
                        .with(csrf())
        )
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value(is(CONTACT_MESSAGE_1)))
        ;


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