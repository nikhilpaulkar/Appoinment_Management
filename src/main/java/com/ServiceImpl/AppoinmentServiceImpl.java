package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceInterface.AppoinmentServiceInterface;
import com.dto.AppointmentDto;
import com.entity.Appointment;

import com.repository.AppointmentRepository;

@Service
public class AppoinmentServiceImpl implements AppoinmentServiceInterface
{
  
	@Autowired
	private AppointmentRepository appointmentRepository;

	
	
	
	// create appointment 
	@Override
	public void createappointment(AppointmentDto appointmentDto) 
	{
		Appointment appointment=new Appointment();
		
		appointment.setDescription(appointment.getDescription());
		appointment.setManagerid(appointment.getManagerid());
		appointment.setCreatedat(appointmentDto.getCreatedat());
		
		
	}
	
	
}
