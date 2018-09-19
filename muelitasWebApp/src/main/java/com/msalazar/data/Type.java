package com.msalazar.data;


public class Type {

	int id;
	String desc;
	String parent;
	
	/* constructors */
	
	public Type() {
		// TODO Auto-generated constructor stub
	}
	
	public Type(int id, String desc, String parent){
		this.id = id;
		this.desc = desc;
		this.parent = parent;
	}
	
	/* getters and setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "Type [id=" + id + ", desc=" + desc + ", parent=" + parent + "]";
	}

}
