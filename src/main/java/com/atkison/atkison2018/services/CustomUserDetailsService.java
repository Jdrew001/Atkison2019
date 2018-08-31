package com.atkison.atkison2018.services;

import com.atkison.atkison2018.configurations.EmailNotFoundException;
import com.atkison.atkison2018.models.CustomUserDetails;
import com.atkison.atkison2018.models.User;
import com.atkison.atkison2018.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUsers = userRepository.findByEmail(s);

        optionalUsers
                .orElseThrow(() -> new EmailNotFoundException("Email not found"));

        return optionalUsers.map(CustomUserDetails::new).get();
    }
}
