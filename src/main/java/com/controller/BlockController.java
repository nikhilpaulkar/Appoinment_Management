package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ServiceInterface.BlockServiceInterface;
import com.dto.BlockListDto;
import com.dto.ErrorResponseDto;
import com.dto.SucessResponseDto;
import com.entity.BlockList;
import com.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/block")
public class BlockController
{

	@Autowired
	private BlockServiceInterface blockServiceInterface;
	
	
	@PostMapping
	public ResponseEntity<?>block(@RequestBody BlockListDto blockListDto)
	{
	 try
		{
		   blockServiceInterface.blockUser(blockListDto);
		   return new ResponseEntity<>( new SucessResponseDto("block ","block Successfully","the user has block"),HttpStatus.ACCEPTED);
		}catch(ResourceNotFoundException e)
	    {
			return new ResponseEntity<>(new ErrorResponseDto("not found","no"),HttpStatus.NOT_FOUND);
			
	    }
	}
	
}
