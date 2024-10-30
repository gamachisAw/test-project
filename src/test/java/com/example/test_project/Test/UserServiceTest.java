package com.example.test_project.Test;

import com.example.test_project.Model.User;
import com.example.test_project.Repository.UserRepository;
import com.example.test_project.Service.Impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setPhoneNumber("123456789");


        when(userRepository.save(any(User.class))).thenReturn(user);


        userService.saveUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User();
        user1.setFirstName("User1");
        user1.setLastName("Test1");
        user1.setEmail("user1@example.com");
        user1.setPhoneNumber("1234567890");

        User user2 = new User();
        user2.setFirstName("User2");
        user2.setLastName("Test2");
        user2.setEmail("user2@example.com");
        user2.setPhoneNumber("0987654321");


        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getAllUsers();


        assertEquals(2, users.size(), "There should be 2 users in the list");
        assertEquals("user1@example.com", users.get(0).getEmail());
        assertEquals("user2@example.com", users.get(1).getEmail());

        verify(userRepository, times(1)).findAll();
    }



    @Test
    void testUpdateUser() {
        User existingUser = new User();
        existingUser.setId(1L);
        existingUser.setFirstName("OldName");
        existingUser.setLastName("OldLast");
        existingUser.setEmail("old@example.com");
        existingUser.setPhoneNumber("123456789");

        User updatedUser = new User();
        updatedUser.setId(1L);
        updatedUser.setFirstName("NewName");
        updatedUser.setLastName("NewLast");
        updatedUser.setEmail("new@example.com");
        updatedUser.setPhoneNumber("987654321");

        // Mock the behavior of userRepository
        when(userRepository.findById(1L)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        // Call the service method
        userService.updateUser(updatedUser, 1L);

        // Verify that the save method was called with the updated user
        verify(userRepository, times(1)).save(existingUser);
        assertEquals("NewName", existingUser.getFirstName());
    }

    @Test
    void testDeleteUser() {
        long userId = 1L;

        userService.deleteUser(userId);

        // Verify that deleteById was called
        verify(userRepository, times(1)).deleteById(userId);
    }
}
