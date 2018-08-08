import java.util.ArrayList;


public class Type {

	Integer id;
	String desc;
	String parent;
	
	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	public Type(Integer _id, String _desc, String _parent){
		this.id = _id;
		this.desc = _desc;
		this.parent = _parent;
	}
	
	public ArrayList<Type> getPersonTypes(){
		ArrayList<Type> T = new ArrayList<Type>();
		//get just PE - Person from table "type"
		
		return T;
	}
	
	public ArrayList<Type> getOcupations(){
		ArrayList<Type> T = new ArrayList<Type>();
		//get just OC - Person from table "type"
		
		return T;
	}
	
	public ArrayList <Type> getSpecialitist(){
		ArrayList<Type> T = new ArrayList<Type>();
		//get just SP - Person from table "type"
		
		return T;
	}
	
	public ArrayList <Type> getAppointmentStatus(){
		ArrayList<Type> T = new ArrayList<Type>();
		//get just AS - Appointment status from table "type"
		
		return T;
	}
	
	public Integer loadByDesc(String desc, String parent){
		Integer _id=1;
		//look for coincidences in the db to load the info
	
		if(_id==1){
			_id=1;
		} else
		{
			_id=null;
		}
		return _id;
	}

}
