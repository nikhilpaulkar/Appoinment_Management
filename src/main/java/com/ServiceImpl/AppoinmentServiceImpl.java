package com.ServiceImpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ServiceInterface.AppoinmentServiceInterface;
import com.ServiceInterface.IRoleListDto;
import com.dto.AppointmentDto;
import com.dto.AttendessDto;
import com.entity.Appointment;
import com.entity.Attendess;
import com.entity.Users;
import com.exception.ResourceNotFoundException;
import com.repository.AppointmentRepository;
import com.repository.AttendessRepository;
import com.repository.UserRepository;
import com.utility.Pagination;
import com.webSecurity.JwtTokenUtil;

@Service
public  class AppoinmentServiceImpl implements AppoinmentServiceInterface
{
  
	@Autowired
	private AppointmentRepository appointmentRepository;

	
	@Autowired
	private AttendessRepository attendessRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenlUtil;
	
	// create appointment 
	@Override
	public Appointment createappointment(AppointmentDto appointmentDto,HttpServletRequest request) 
	{
//		final String header=request.getHeader("Authorization");
//		String requestToken=header.substring(7);
// 
//		final String email=jwtTokenlUtil.getUsernameFromToken(requestToken);
//	
//		Users userEntity=userRepository.findByEmailContainingIgnoreCase(email);
//		
//		Integer userId=userEntity.getId();
		Appointment appointment=new Appointment();
		
		appointment.setDescription(appointmentDto.getDescription());
		appointment.setCreatedat(appointmentDto.getCreatedat());
		appointment.setManagerid(appointmentDto.getManagerid());
	    return this.appointmentRepository.save(appointment);
	    
	}
	
	// get all appointment with pagination
	@Override
	public List<Attendess> findAttendeesAppointment(String search,String pageNumber,String pageSize)
	{

	
    return null;
	}
	
	
	
    // delete appointment only manager
	@Override
	public void deleteAppointment(Integer id)
	{
		this.appointmentRepository.findById(id).orElseThrow( () -> 
		new ResourceNotFoundException("appointment not found" +id));
        this.appointmentRepository.deleteById(id);

    }


	
	
}
