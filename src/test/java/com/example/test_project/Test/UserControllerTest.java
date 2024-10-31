package com.example.test_project.Test;

import com.example.test_project.Controller.UserController;
import com.example.test_project.Model.User;
import com.example.test_project.Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        user = new User();
        user.setId(1L);
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPhoneNumber("1234567890");
    }

    @Test
    void testSetUser() throws Exception {
        doNothing().when(userService).saveUser(any(User.class));

        mockMvc.perform(post("/save/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(status().isOk());

        verify(userService, times(1)).saveUser(any(User.class));
    }

    @Test
    void testGetAllUsers() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(user);
        when(userService.getAllUsers()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)) // Check for JSON response
                .andExpect(jsonPath("$[0].firstName").value("John")) // Verify the content of the JSON
                .andExpect(jsonPath("$[0].lastName").value("Doe"));  // Additional checks can be added here
    }



    @Test
    void testUpdateUser() throws Exception {
        doNothing().when(userService).updateUser(any(User.class), eq(1L));

        mockMvc.perform(put("/update/users/1")
                        .contentType(MediaType.APPLICATION_JSON) // Set content type to JSON
                        .content("{\"firstName\":\"Jane\", \"lastName\":\"Doe\", \"email\":\"jane.doe@example.com\", \"phoneNumber\":\"0987654321\"}")) // JSON content
                .andExpect(status().isOk());

        verify(userService, times(1)).updateUser(any(User.class), eq(1L));
    }


    @Test
    void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteUser(1L);

        mockMvc.perform(delete("/delete/users/1"))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteUser(1L);
    }
}
