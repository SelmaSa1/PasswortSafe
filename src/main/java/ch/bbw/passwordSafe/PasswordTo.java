package ch.bbw.passwordSafe;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
