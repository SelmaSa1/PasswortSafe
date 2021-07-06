package ch.bbw.passwortsafe;

import ch.bbw.passwortsafe.Decrypt;
import ch.bbw.passwortsafe.Encrypt;
import ch.bbw.passwortsafe.PasswordCreateTo;
import ch.bbw.passwortsafe.PasswordTo;
import ch.bbw.passwortsafe.Password;
import ch.bbw.passwortsafe.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepositoryImpl repository;

    private byte[] key;
    private final Decrypt decrypt = new Decrypt();
    private final Encrypt encrypt = new Encrypt();

    public PasswordService() {
        byte[] encoded = "SecretKey123".getBytes();
        SecretKey secretKey = new SecretKeySpec(encoded, "AES");
        this.key = secretKey.getEncoded();
    }

    public List<PasswordTo> getAll() {
        List<PasswordTo> passwordTos = new ArrayList<>();
        this.repository.findAll().forEach(password -> {
            PasswordTo passwordTo = new PasswordTo(
                    password.getId(),
                    password.getWebsite(),
                    password.getUsername(),
                    decrypt.decrypt(password.getPassword(), key),
                    password.getRemarks());
            passwordTos.add(passwordTo);
        });
        return passwordTos;
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public void addPassword(PasswordCreateTo passwordCreate) {
        Password password = new Password(
                passwordCreate.getWebsite(),
                passwordCreate.getUsername(),
                encrypt.encrypt(passwordCreate.getPassword().getBytes(), key),
                passwordCreate.getRemarks()
        );
        this.repository.save(password);
    }
}
