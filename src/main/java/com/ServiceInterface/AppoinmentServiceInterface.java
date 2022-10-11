package com.ServiceInterface;


import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.dto.AppointmentDto;




public interface AppoinmentServiceInterface 
{
	
	
	
	AppointmentDto createappointment(AppointmentDto appointmentDto, HttpServletRequest request);
	
	
	
	Page<IAppointmentDto> getAllAppointment(String search, String pageNumber, String pageSize);

    

	void deleteAppointment(Long id, HttpServletRequest request);

     
                     
}
