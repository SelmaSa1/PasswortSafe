package ch.bbw.passwortsafe;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Decrypt {
    public String decrypt(byte[] encryptedData, byte[] key) {
        try {
            Cipher c = Cipher.getInstance("AES");
            SecretKeySpec k = new SecretKeySpec(key, "AES");
            c.init(Cipher.DECRYPT_MODE, k);
            byte[] data = c.doFinal(encryptedData);
            return new String(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
