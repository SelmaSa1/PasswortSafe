package ch.bbw.passwordSafe;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {

	public byte[] encrypt(byte[] passwort, byte[] key) {
		try {
			Cipher c = Cipher.getInstance("AES");
			SecretKeySpec k = new SecretKeySpec(key, "AES");
			c.init(Cipher.ENCRYPT_MODE, k);
			return c.doFinal(passwort);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
