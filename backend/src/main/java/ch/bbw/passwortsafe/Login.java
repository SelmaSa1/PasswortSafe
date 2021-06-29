package ch.bbw.passwortsafe;

import java.security.MessageDigest;
import java.util.Arrays;

public class Login {

    public boolean isPasswordMatching(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            String password1 = "b109f3bbbc244eb82441917ed06d618b9008dd09b3befd1b5e07394c706a8bb980b1d7785e5976ec049b46df5f1326af5a2ea6d103fd07c95385ffab0cacbc86";
            return Arrays.equals(bytes, password1.getBytes());
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
