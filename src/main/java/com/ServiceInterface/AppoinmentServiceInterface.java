package com.ServiceInterface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dto.AppointmentDto;
import com.entity.Appointment;
import com.entity.Attendess;

public interface AppoinmentServiceInterface 
{
	
	
	
	AppointmentDto createappointment(AppointmentDto appointmentDto, HttpServletRequest request);
	
	List<Appointment> findManagerAppointment(String  pageNumber, String pageSize, String name);

	void deleteAppointment(Integer id, HttpServletRequest request);
	
}
