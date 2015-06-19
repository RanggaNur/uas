public class UserLogin
{
	private String userName;
	private String password;
	private String stts;
	
	public UserLogin(String userName, String password, String stts)
	{
		this.userName = userName;
		this.password = password;
		this.stts = stts;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getStts()
	{
		return stts;
	}
	
	public boolean cekStatus(String status)
	{
		return (status.equalsIgnoreCase(stts));
	}
	
	public boolean checkPassUser(String user, String pass, String status)
	{
		return (user.equals(userName) && (pass.equals(password)) && (status.equals(stts)));
	}
	
	public void setPassword(String pass)
	{
		password = pass;
	}
}