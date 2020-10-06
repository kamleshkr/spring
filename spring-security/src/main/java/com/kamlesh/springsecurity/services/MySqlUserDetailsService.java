package com.kamlesh.springsecurity.services;

import com.kamlesh.springsecurity.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import security.AppUserDetails;

public class MySqlUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AppUserDetails(
                userRepository.findUserByUsername(username)
                        .orElseThrow(() -> new UsernameNotFoundException("User not found!")));
    }
}
