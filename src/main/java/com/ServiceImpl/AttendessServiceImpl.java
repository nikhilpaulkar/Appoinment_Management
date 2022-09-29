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
  public Attendess updateStatus(AttendessDto attendeesDto, Integer id)
  {
	
       Attendess  attendess =this.attendessRepository.findById(id).orElseThrow(() ->
       new ResourceNotFoundException("appointment not  Found "+id));
       attendess.setStatus(attendeesDto.getStatus());
	   return attendessRepository.save(attendess);
		
  }



}
