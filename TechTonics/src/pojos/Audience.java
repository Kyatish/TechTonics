package pojos;

public class Audience {
	int talkid;
	String email, name;

	public Audience(int talkid, String email, String name) {
		super();
		this.talkid = talkid;
		this.email = email;
		this.name = name;
	}

	public int getTalkid() {
		return talkid;
	}

	public void setTalkid(int talkid) {
		this.talkid = talkid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Audience [talkid=" + talkid + ", email=" + email + ", name="
				+ name + "]";
	}

}
