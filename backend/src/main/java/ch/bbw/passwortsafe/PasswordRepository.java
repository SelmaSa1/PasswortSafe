package ch.bbw.passwortsafe;

import org.springframework.data.jpa.repository.JpaRepository;

interface PasswordRepository extends JpaRepository<Password, Long> {

}

