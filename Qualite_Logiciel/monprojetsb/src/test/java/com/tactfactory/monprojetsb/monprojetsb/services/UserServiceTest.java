package com.tactfactory.monprojetsb.monprojetsb.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.tactfactory.monprojetsb.monprojetsb.MonprojetsbApplicationTests;
import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.mock.MockitoUserRepository;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;

@ActiveProfiles("test")
@TestPropertySource(locations = { "classpath:application-test.properties" })
@SpringBootTest(classes = MonprojetsbApplicationTests.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
    
    private User entity;
    
//    @Before
//    public void clear() {
//        this.userRepository.deleteAll();
//    }

    @BeforeEach
    public void setUp() throws Exception {
      final MockitoUserRepository mock = new MockitoUserRepository(this.userRepository);
      mock.intialize();
      this.entity = mock.entity;
    }
    
    @Test // 1
    public void TestInsertOne() {
        Long before = userRepository.count();
        userService.save(this.entity);
        Long after = userRepository.count();

        assertEquals(before + 1, after);
    }

    @Test // 2
    public void TestInsertUser() {
        Long id = userService.save(this.entity).getId();
        User userFetch = userRepository.findById(id).get();
        assertEquals(userFetch.getFirstname(), this.entity.getFirstname());
        assertEquals(userFetch.getLastname(), this.entity.getLastname());
        assertEquals(userFetch.getProducts(), this.entity.getProducts());
    }

    @Test // 3
    public void TestUpdate() {
//    	User userBase = new User(5L, "Jean", "François", new ArrayList<Product>());
//        Long id = userService.save(userBase).getId();
//        User userFetch = userService.findById(id);
//        userFetch = userService.save(userFetch);
//        assertEquals(userFetch.getFirstname(), userBase.getFirstname());
//        assertEquals(userFetch.getLastname(), userBase.getLastname());
//        assertEquals(userFetch.getProducts(), userBase.getProducts());
    }

    @Test // 4
    public void TestGetUser() {
		Long id = userService.save(this.entity).getId();
		User userFetch = userRepository.findById(id).get();
		assertEquals(userFetch.getFirstname(), this.entity.getFirstname());
		assertEquals(userFetch.getLastname(), this.entity.getLastname());
		assertEquals(userFetch.getProducts(), this.entity.getProducts());
    }

    @Test // 5
    public void TestGetUsers() {
 
        List<User> users = new ArrayList<User>();
        User user1 = new User(5L, "Jean", "François", new ArrayList<Product>());
        User user2 = new User(6L, "François", "Jean", new ArrayList<Product>());
        
        users.add(user1);
        users.add(user2);

        userService.saveAll(users);

        List<User> usersFetch = userService.findAll();

        for (int i = 0; i < usersFetch.size(); i++) {
    		assertEquals(users.get(i).getFirstname(), usersFetch.get(i).getFirstname());
    		assertEquals(users.get(i).getLastname(), usersFetch.get(i).getLastname());
    		assertEquals(users.get(i).getProducts(), usersFetch.get(i).getProducts());
        }

    }

    @Test // 6
    public void TestDeleteUser() {
        User userTemp = this.entity;
        userService.save(userTemp);
        Long before = userRepository.count();
        userService.delete(userTemp);
        Long after = userRepository.count();

        assertEquals(before - 1, after);
    }

    @Test // 7
    public void Test7() {

    }
}
