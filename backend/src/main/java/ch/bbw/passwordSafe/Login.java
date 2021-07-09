package ch.bbw.passwordSafe;

import java.security.MessageDigest;
import java.util.Arrays;

public class Login {
	byte[] hash;

	public boolean isPasswordMatching(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update("password".getBytes());
			this.hash = md.digest();
			MessageDigest md2 = MessageDigest.getInstance("SHA-512");
			md2.update(password.getBytes());
			byte[] bytes = md2.digest();
			return Arrays.equals(hash, bytes);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean isUserMatching(String user) {
		String user1 = "user";
		return user1.equals(user);
	}

}
