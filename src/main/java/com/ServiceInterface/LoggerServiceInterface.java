package com.ServiceInterface;



import org.springframework.stereotype.Service;

import com.dto.LoggerDto;
import com.entity.LoggerEntity;
import com.entity.Users;
@Service
public interface LoggerServiceInterface 
{
	
	public void createLogger(LoggerDto loggerdto , Users user);

	public LoggerEntity getLoggerDetail(String requestTokenHeader);
    
}
