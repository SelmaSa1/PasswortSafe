package ch.bbw.passwortsafe;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Password {
    private @Id @GeneratedValue Long id;
    private String website;
    private String username;
    private byte[] password;
    private String remarks;

    public Password(String website, String username, byte[] password, String remarks) {
        this.website = website;
        this.username = username;
        this.password = password;
        this.remarks = remarks;
    }

    public Password(String website, String username, byte[] password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public Password() {}

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }
}
