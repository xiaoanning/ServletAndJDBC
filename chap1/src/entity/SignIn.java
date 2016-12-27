package entity;

public class SignIn
{
	public String username ;
	public String password ;
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
	public SignIn(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public SignIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SignIn [username=" + username + ", password=" + password + "]";
	}
	
	
}
