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
import com.entity.RoleEntity;
import com.entity.UserRoleEntity;
import com.entity.Users;
import com.exception.ResourceNotFoundException;
import com.repository.AppointmentRepository;
import com.repository.AttendessRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.utility.Pagination;
import com.webSecurity.JwtTokenUtil;

@Service
public  class AppoinmentServiceImpl implements AppoinmentServiceInterface
{
  
	@Autowired
	private AppointmentRepository appointmentRepository;

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AttendessRepository attendessRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenlUtil;
	
	@Autowired
	private UserRoleRepository  userRoleRepository;
	
	// create appointment only manager
	@Override
	public AppointmentDto createappointment(AppointmentDto appointmentDto,HttpServletRequest request) 
	{
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
 
		final String email=jwtTokenlUtil.getUsernameFromToken(requestToken);
	   
		Users userEntity=userRepository.findByEmail(email);
        System.out.println("hello"+userRepository.findByEmail(email));
		
		Appointment appointment=new Appointment();
		
		appointment.setDescription(appointmentDto.getDescription());
		appointment.setCreatedat(appointmentDto.getCreatedat());
		appointment.setManagerid(appointmentDto.getManagerid());
		
		this.appointmentRepository.save(appointment);
	    return appointmentDto;
	}
	
	// get all appointment with pagination
	public List<Appointment> findManagerAppointment(String pageNumber, String pageSize,String name) 
	 {
//  	 	Users user = userRepository.findByEmail(name);
//  	 
// 	 	Pageable paging= new Pagination().getPagination(pageNumber, pageSize);
//  	 	Page<Appointment> pagedResult= appointmentRepository.findByManagerId(paging, user.getId());
//  	    return pagedResult.toList();
//  	    
      return null;
	}

	
    // delete appointment only manager
	@Override
	public void deleteAppointment(Integer id,HttpServletRequest request)
	{
		
        Appointment appointment= appointmentRepository.findById(id).orElseThrow(()-> 
        new ResourceNotFoundException("not Found appointment Id.."));
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);

		final String email=jwtTokenlUtil.getUsernameFromToken(requestToken);

		Users userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
		Integer integerid=userEntity.getId();
		
		
    	UserRoleEntity userRoleEntity= userRoleRepository.findByUserById(id);
		
		Integer roleEntityId=userRoleEntity.getTask().getRole().getId();
		
		RoleEntity roleEntity1=roleRepository.findById(roleEntityId).orElseThrow(()->
		new ResourceNotFoundException("Not Found Roleid"));
		String roleName=roleEntity1.getRoleName();
		
		if(roleName.equals("manager"))
		{
			appointmentRepository.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException("Cannot Access.. Only Access to manager the Delete appointment..");
		}
		
		///
		this.appointmentRepository.findById(id).orElseThrow( () ->
		new ResourceNotFoundException("appointment not found" +id));
		this.appointmentRepository.deleteById(id);

    }


	
	
}
