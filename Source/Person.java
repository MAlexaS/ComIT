import java.util.Date;

public abstract class Person
{
	protected Integer id;
	
	protected String name;
	protected String lastName;
	protected String address;
	protected String zipcode;
	protected Date bornDate;
	protected String phone;
	protected String cellphone;
	protected String email;
	protected Type type;
	
	public Person(){
		
	}
	
	public Person(Integer _id,String _name, String _lastName, String _address, String _zipcode, Date _bornDate, String _phone, String _cellphone,String _email, Type _type)
	{
		this.id=_id;
		this.name = _name;
		this.lastName = _lastName;
		this.address = _address;
		this.zipcode = _zipcode;
		this.bornDate = _bornDate;
		this.phone = _phone;
		this.cellphone = _cellphone;
		this.email = _email;
		this.type = _type;
	}

	
}
