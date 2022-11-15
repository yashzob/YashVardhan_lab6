package com.StuDebate.StudentReg.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.StuDebate.StudentReg.Model.User;
import com.StuDebate.StudentReg.Security.MyUserDetails;
import com.StuDebate.StudentReg.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	
	
	 @Autowired
	    private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
        
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
	}
	
	
}
