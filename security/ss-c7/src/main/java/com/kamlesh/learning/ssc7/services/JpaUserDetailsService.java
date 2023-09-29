package com.kamlesh.learning.ssc6.services;

import com.kamlesh.learning.ssc6.entities.User;
import com.kamlesh.learning.ssc6.repositories.UserRepository;
import com.kamlesh.learning.ssc6.security.model.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var userOptional = userRepository.findUserByUsername(username);
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found in DB!"));
        return new SecurityUser(user);
    }
}
