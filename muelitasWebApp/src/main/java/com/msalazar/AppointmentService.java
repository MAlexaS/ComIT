package com.msalazar;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.msalazar.data.Appointment;
import com.msalazar.data.Speciality;
import com.msalazar.data.Doctor;
import com.msalazar.data.User;
import com.msalazar.exceptions.MuelitasException;
import com.msalazar.persistence.AppointmentPersistence;
import com.msalazar.persistence.SpecialityPersistence;
import com.msalazar.persistence.UserPersistence;

public class AppointmentService {
	
	private static List<Speciality> specialities = new ArrayList<Speciality>();
	private static List<Appointment> appointments = new ArrayList();
	
	static {
		//appointments.add(new Appointment(1,new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-10"),)
	}
	
	public String getSpecialities(String strDate) {
		SpecialityPersistence objPers = new SpecialityPersistence();
		String cad = "";
		
		try {
			List<Speciality> specs=objPers.getAll();
			
			/*

		[
          { id: 'a', title: 'Speciality A', occupancy: 40 },
          { id: 'b', title: 'Speciality B', occupancy: 40, eventColor: 'green' },
          { id: 'c', title: 'Speciality C', occupancy: 40, eventColor: 'orange' },
          { id: 'd', title: 'Speciality D', occupancy: 40, children: [
            { id: 'd1', title: 'Doctor D1', occupancy: 10 },
            { id: 'd2', title: 'Doctor D2', occupancy: 10 }
          ] },
        
        ]

			 */
			for (Speciality speciality : specs) {
				cad +="{ id: '"+ speciality.getId() +"', title: '"+ speciality.getDesc()+"', occupancy: 40, eventColor: 'green' ";
				cad += ", children: [";
				for (Doctor specDocs : speciality.getDoctors()) {
					cad += "{ id: '"+ specDocs.getId() +"', title: '"+specDocs.getLastName() + " "+ specDocs.getName()+"', occupancy: 10 },";
				}
				//drop last character ","
				cad=cad.substring(0, cad.length()-1);
				cad += "] },";
				cad +="},";
			}
			//drop last character ","
			cad=cad.substring(0, cad.length()-1);
			return(cad);
		} catch (MuelitasException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//objPers.getById(id)
		return "";
	}
	


}
