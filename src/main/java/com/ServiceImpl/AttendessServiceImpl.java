package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceInterface.AttendessServiceInterface;
import com.dto.AttendessDto;
import com.entity.Attendess;

import com.exception.ResourceNotFoundException;
import com.repository.AttendessRepository;
@Service
public class AttendessServiceImpl implements AttendessServiceInterface
{
   @Autowired
   private AttendessRepository attendessRepository;

   
   // update status by developer 
  @Override
  public AttendessDto updateStatus(AttendessDto attendeesDto, Integer id)
  {
	
	    Attendess attendess =attendessRepository.findById(id).orElseThrow(()-> 
	    new ResourceNotFoundException("Not Found appointmetn Id"));
		attendess.setStatus(attendeesDto.isStatus());
		attendessRepository.save(attendess);
		return attendeesDto;
		
  }
 

}
