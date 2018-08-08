public abstract class User
{
	protected String id;
	private String password;
	protected String name;
	protected String lastName;
	protected String email;
	

	public User(String _id,String _name, String _lastName, String _email, String _password)
	{
		this.id=_id;
		this.name = _name;
		this.lastName = _lastName;
		this.email = _email;
		this.password = _password;
	}

	public final boolean loginUser(String id, String password)
	{
		//Verify User
		
		//Verify Password
		return  true; //true or false;
	}
	
	public final boolean changePassword(String id, String oldPassword, String newPassword){
		//Verify oldPassword
		
		//Change Password
		return true;
	}

	public final boolean checkUser(String id){
		
		//verify unique user id
		return true;
	}
}
