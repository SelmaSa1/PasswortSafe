package ch.bbw.passwortsafe;

public class PasswordTo {
    private Long id;
    private String website;
    private String username;
    private String password;
    private String remarks;

    public PasswordTo(Long id, String website, String username, String password, String remarks) {
        this.id = id;
        this.website = website;
        this.username = username;
        this.password = password;
        this.remarks = remarks;
    }
}
