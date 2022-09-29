package com.ServiceInterface;

import com.dto.AttendessDto;
import com.entity.Attendess;

public interface AttendessServiceInterface 
{


	Attendess updateStatus(AttendessDto attendeesDto, Integer id);

}
