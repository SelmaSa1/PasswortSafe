package ch.bbw.passwortsafe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PasswordRepository extends JpaRepository<Password, Long> {

}

