package com.msalazar.data;

import java.util.Date;

public class DayOff {

	private Date id;
	private String desc;
	
	public DayOff() {
		
	}
	
	public DayOff(Date id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}
	public Date getId() {
		return id;
	}
	public void setId(Date id) {
		this.id = id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "DayOff [id=" + id + ", desc=" + desc + "]";
	}
	
	
	
}
