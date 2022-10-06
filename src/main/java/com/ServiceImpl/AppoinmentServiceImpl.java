package com.ServiceImpl;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.ServiceInterface.AppoinmentServiceInterface;
import com.ServiceInterface.IAppointmentDto;

import com.dto.AppointmentDto;

import com.entity.Appointment;
import com.entity.Attendess;
import com.entity.BlockList;
import com.entity.UserRoleEntity;
import com.entity.Users;
import com.exception.ResourceNotFoundException;
import com.repository.AppointmentRepository;
import com.repository.AttendessRepository;
import com.repository.BlockRepository;
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
	private AttendessRepository attendessRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenlUtil;
	
	@Autowired
	private UserRoleRepository  userRoleRepository;
	
	@Autowired
	private BlockRepository blockRepository;
	
	
	// create appointment only manager
	@Override
	public AppointmentDto createappointment(AppointmentDto appointmentDto,HttpServletRequest request) 
	{
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
 
		final String email=jwtTokenlUtil.getUsernameFromToken(requestToken);
	   
		Users user1=userRepository.findByEmail(email);
        int id=user1.getId();
        UserRoleEntity userRoleEntity= userRoleRepository.findTaskRoleIdByTaskUserId(id);
        String name=userRoleEntity.getTask().getRole().getRoleName();
        System.out.println("Role name:"+name);
      
        if(name.equals("Manager"))
        {
    	
    	 Appointment appointment=new Appointment();
   		
   		 appointment.setDescription(appointmentDto.getDescription());
   		 appointment.setCreatedat(appointmentDto.getCreatedat());
   		 appointment.setManagerid(appointmentDto.getManagerid());
  		 this.appointmentRepository.save(appointment);
  	   	   
  		 
//  	  BlockList blockList =this.blockRepository.findById(appointmentDto.getDeveloperid()).get();
//  	  int  user =	blockList.getBlockUser();
//   	  if(appointmentDto.getDeveloperid==blockLit.getBlockUser)
// 		  {
//   	   
//	          throw new ResourceNotFoundException("Not create appointment the user has block");
// 		  }
     	 Attendess attendess=this.attendessRepository.findById(appointmentDto.getDeveloperid()).orElseThrow(() -> 
     	 new ResourceNotFoundException("developer id  not found"));
  	
		 attendess.setAppointmentid(appointment); 
		
   		 attendess.setDeveloperid(user1.getId());	
   		 attendess.setStatus(true);
   		 this.attendessRepository.save(attendess);
  
   	     return appointmentDto;
   		 
    
        }
       else
       {
    	  
    	   throw new ResourceNotFoundException("Can not access ... only manager can create appointment !!!");
       }

	}
	
	

	 // get all appointment with pagination
	 public Page<IAppointmentDto> getAllAppointment(String search, String pageNumber, String pageSize) 
	  {
			Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
			if((search=="")||(search==null)||(search.length()==0))
			{
				return appointmentRepository.findByOrderById(pagable,IAppointmentDto.class);
			}
			else
			{
				return  appointmentRepository.findByCreatedAtByAsc(search,pagable,IAppointmentDto.class);
			}
			
	     }

	
    // delete appointment only manager
    @Override
	public void deleteAppointment(Integer id,HttpServletRequest request)
	{
	
        appointmentRepository.findById(id).orElseThrow(()-> 
    
        new ResourceNotFoundException("not Found appointment Id.."));
     
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
		final String token=jwtTokenlUtil.getUsernameFromToken(requestToken);
        
        Users userEntity=userRepository.findByEmailContainingIgnoreCase(token);
    	UserRoleEntity userRoleEntity= userRoleRepository.findTaskRoleIdByTaskUserId(userEntity.getId());
    	String name=userRoleEntity.getTask().getRole().getRoleName();
    
		if(name.equals("Manager"))
		{
			appointmentRepository.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException("Cannot Access.. Only manager can Delete appointment..");
		}
		
		
		
       }


	


	
	
}
