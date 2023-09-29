package com.kamlesh.learning.ssc6.repositories;

import com.kamlesh.learning.ssc6.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findUserByUsername(String username);
}
