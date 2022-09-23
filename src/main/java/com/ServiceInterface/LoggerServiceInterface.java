package com.ServiceInterface;

import com.dto.LoggerDto;
import com.entity.LoggerEntity;
import com.entity.User;

public interface LoggerServiceInterface 
{
	
	public void createLogger(LoggerDto loggerdto , User user);

	public LoggerEntity getLoggerDetail(String requestTokenHeader);
    
}
