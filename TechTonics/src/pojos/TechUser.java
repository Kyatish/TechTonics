package pojos;

import java.sql.Date;

public class TechUser {
	String email, userName, password;
	Date dateOfSubscription;

	public TechUser(String email, String userName, String password,
			Date dateOfSubscription) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.dateOfSubscription = dateOfSubscription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfSubscription() {
		return dateOfSubscription;
	}

	public void setDateOfSubscription(Date dateOfSubscription) {
		this.dateOfSubscription = dateOfSubscription;
	}

	@Override
	public String toString() {
		return "TechUser [email=" + email + ", userName=" + userName
				+ ", password=" + password + ", dateOfSubscription="
				+ dateOfSubscription + "]";
	}
}
