package ch.bbw.passwordSafe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PasswordService {

	private final PasswordRepository repository;

	private byte[] key;
	private final Decrypt decrypt = new Decrypt();
	private final Encrypt encrypt = new Encrypt();

	@Autowired
	public PasswordService(PasswordRepository passwordRepository) {
		try {
			byte[] key = "SymmetricPw4711.".getBytes();
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(key);
			byte[] fullHash = md.digest();
			this.key = Arrays.copyOfRange(fullHash, 48, fullHash.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repository = passwordRepository;
		repository.save(new Password("google", "user", encrypt.encrypt("superSecret123".getBytes(), key), "note"));
		repository.save(new Password("teams", "user1", encrypt.encrypt("Secret44!".getBytes(), key)));
		repository.save(new Password("word", "user2", encrypt.encrypt("sAfePAssword33+".getBytes(), key), "note note note"));
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
		System.out.println(passwordCreate.getPassword());
		Password password = new Password(
				passwordCreate.getWebsite(),
				passwordCreate.getUsername(),
				encrypt.encrypt(passwordCreate.getPassword().getBytes(), key),
				passwordCreate.getRemarks()
		);
		this.repository.save(password);
	}
}
