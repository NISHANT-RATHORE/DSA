package com.example.security.Service;

import com.example.security.Model.Student;
import com.example.security.Repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserService implements UserDetailsService {

    @Autowired
    private MyUserRepo myUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = myUserRepo.findByUsername(username);
        if (student == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return User.withUsername(student.getUsername())
                   .password(student.getPassword())
                   .roles(student.getRole())
                   .build();
    }
}