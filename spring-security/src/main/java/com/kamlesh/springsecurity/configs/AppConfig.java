package com.kamlesh.springsecurity.configs;

import com.kamlesh.springsecurity.services.MySqlUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return getMySqlBasedUserDetails();
        //return getDummyUserDetails();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    private UserDetailsService getMySqlBasedUserDetails() {
        return new MySqlUserDetailsService();
    }

    private UserDetailsService getDummyUserDetails() {
        var userDetailsService = new InMemoryUserDetailsManager();
        var userDetails = User.withUsername("admin")
                .password("admin")
                .authorities("read")
                .build();
        userDetailsService.createUser(userDetails);
        return userDetailsService;
    }
}
