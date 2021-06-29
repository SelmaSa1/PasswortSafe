package ch.bbw.passwortsafe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {
    private Encrypt encrypt = new Encrypt();

    @Bean
    CommandLineRunner initDatabase(PasswordRepository repository) {

        return args -> {
            //repository.save(new Password("google", "user", encrypt.encrypt("password".getBytes(), key), "note"));
            //repository.save(new Password("bla", "user1", encrypt.encrypt("password1".getBytes(), key)));
            //repository.save(new Password("blabla", "user2", encrypt.encrypt("password2".getBytes(), key), "note note note"));
        };
    }
}

