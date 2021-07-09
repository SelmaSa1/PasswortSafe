package ch.bbw.passwordSafe;

public class PasswordCreateTo {
	private String website;
	private String username;
	private String password;
	private String remarks;

	public PasswordCreateTo(String website, String username, String password, String remarks) {
		this.website = website;
		this.username = username;
		this.password = password;
		this.remarks = remarks;
	}

	public String getWebsite() {
		return website;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRemarks() {
		return remarks;
	}
}
