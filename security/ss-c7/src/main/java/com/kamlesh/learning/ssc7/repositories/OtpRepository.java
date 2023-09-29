package com.kamlesh.learning.ssc6.repositories;

import com.kamlesh.learning.ssc6.entities.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OtpRepository extends JpaRepository<Otp, Integer> {

    Optional<Otp> findOtpByUsername(String username);

}
