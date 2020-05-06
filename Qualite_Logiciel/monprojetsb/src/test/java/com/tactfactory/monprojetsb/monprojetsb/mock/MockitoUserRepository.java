package com.tactfactory.monprojetsb.monprojetsb.mock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import static org.mockito.ArgumentMatchers.any;

import com.tactfactory.monprojetsb.monprojetsb.entities.User;
import com.tactfactory.monprojetsb.monprojetsb.repository.UserRepository;

public class MockitoUserRepository {
	  protected final UserRepository repository;

	  public User entity;
	  
	  public List<User> users = new ArrayList();
  
	  public Long count = 0L;

	  public MockitoUserRepository(UserRepository repository) {
	    this.repository = repository;

	    this.entity = new User();
	    this.entity.setFirstname("f1");
	    this.entity.setLastname("l1");

	  }

	  public void intialize() {
	    // this.configure();

		Mockito.when(repository.findById(any())).thenAnswer((Answer<Optional<User>>) 
			invocation -> users.stream().filter(
					user -> user.getId() == (long) invocation.getArgument(0)).findFirst()
			);

	    Mockito.when(repository.findAll()).thenReturn(MockitoUserRepository.this.users);
	    
        Mockito.doAnswer((i) -> {
            if (i.getMethod().getName().equals("delete")) {
                MockitoUserRepository.this.users.remove(users.stream().filter(user -> user.getId() == i.<User>getArgument(0).getId()).findFirst().orElse(null));
            }
            return null;
        }).when(this.repository).delete(ArgumentMatchers.any());
	    
	    Mockito.when(this.repository.count()).thenAnswer(new Answer<Long>() {

			@Override
			public Long answer(InvocationOnMock invocation) throws Throwable {
				return MockitoUserRepository.this.count();
			}
	    	
	    });
	    
	    Mockito.when(this.repository.save(any())).thenAnswer(new Answer<User>() {

	      @Override
	      public User answer(InvocationOnMock invocation) throws Throwable {
	        User user = invocation.getArgument(0);
	        long currentId = MockitoUserRepository.this.count() + 1;
	        user.setId(currentId);
	        MockitoUserRepository.this.users.add(user);
	        return user;
	      }
	    });
	    
        Mockito.when(repository.saveAll(any())).thenAnswer((Answer<List<User>>) invocation -> {
            List<User> argUsers = invocation.getArgument(0);
            for (User user : argUsers) {
            	long currentId = MockitoUserRepository.this.count() + 1;
                user.setId(currentId);
                MockitoUserRepository.this.users.add(user);
            }
            return MockitoUserRepository.this.users;
        });
        
	  }
		private Long count() {
		    return (long) users.size();
		}
}
