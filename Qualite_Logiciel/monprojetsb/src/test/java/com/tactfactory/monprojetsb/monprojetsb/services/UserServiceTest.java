package com.tactfactory.monprojetsb.monprojetsb.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EntityScan(basePackages="com.tactfactory.monprojetsb.monprojetsb")
@ComponentScan(basePackages="com.tactfactory.monprojetsb.monprojetsb")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;
    
    @Before
    public void clear() {
        this.userRepository.deleteAll();
    }

    @Test // 1
    public void TestInsertOne() {
        Long before = userRepository.count();// test 1
        userService.save(new User());
        Long after = userRepository.count();

        assertEquals(before + 1, after);
    }

    @Test // 2
    public void TestInsertUser() {
        User userBase = new User( 5L, "Jean", "François", new ArrayList<Product>());
        Long id = userService.save(userBase).getId();
        User userFetch = userRepository.getOne(id);
        assertEquals(userFetch.getFirstname(), userBase.getFirstname());
        assertEquals(userFetch.getLastname(), userBase.getLastname());
        assertEquals(userFetch.getProducts(), userBase.getProducts());
    }

    @Test // 3
    public void TestUpdate() {
//    	User userBase = new User(5L, "Jean", "François", new ArrayList<Product>());
//        Long id = userService.save(userBase).getId();
//        User userFetch = userRepository.getOne(id);
//        userFetch = userService.save(userFetch);
//        assertEquals(userFetch.getFirstname(), userBase.getFirstname());
//        assertEquals(userFetch.getLastname(), userBase.getLastname());
//        assertEquals(userFetch.getProducts(), userBase.getProducts());
    }

    @Test // 4
    public void TestGetUser() {
		User userBase = new User(5L, "Jean", "François", new ArrayList<Product>());
		Long id = userRepository.save(userBase).getId();
		User userFetch = userRepository.getOne(id);
		assertEquals(userFetch.getFirstname(), userBase.getFirstname());
		assertEquals(userFetch.getLastname(), userBase.getLastname());
		assertEquals(userFetch.getProducts(), userBase.getProducts());
    }

    @Test // 5
    public void TestGetUsers() {
 
        List<User> users = new ArrayList<User>();
        User user1 = new User(5L, "Jean", "François", new ArrayList<Product>());
        User user2 = new User(6L, "François", "Jean", new ArrayList<Product>());
        
        users.add(user1);
        users.add(user2);

        userService.saveList(users);

        List<User> usersFetch = userService.findAll();

        for (int i = 0; i < usersFetch.size(); i++) {
    		assertEquals(users.get(i).getFirstname(), usersFetch.get(i).getFirstname());
    		assertEquals(users.get(i).getLastname(), usersFetch.get(i).getLastname());
    		assertEquals(users.get(i).getProducts(), usersFetch.get(i).getProducts());
        }

    }

    @Test // 6
    public void TestDeleteUser() {
        User userTemp = new User();
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
