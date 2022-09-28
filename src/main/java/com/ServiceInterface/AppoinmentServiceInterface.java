package com.ServiceInterface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dto.AppointmentDto;
import com.entity.Appointment;
import com.entity.Attendess;

public interface AppoinmentServiceInterface 
{
	
	void deleteAppointment(Integer id);
	List<Attendess> findAttendeesAppointment(String search, String pageNumber, String pageSize);
	Appointment createappointment(AppointmentDto appointmentDto, HttpServletRequest request);
	
}
