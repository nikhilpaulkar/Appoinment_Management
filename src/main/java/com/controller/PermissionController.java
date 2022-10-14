package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ServiceInterface.IPermissionListDto;

import com.ServiceInterface.PermissionServiceInterface;
import com.dto.ErrorResponseDto;
import com.dto.PermissionDto;

import com.dto.SucessResponseDto;
import com.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/permission")
public class PermissionController 
{
 
	
   @Autowired
   private PermissionServiceInterface permissionServiceInterface;
   
   // add permission
   @PostMapping()
   public  ResponseEntity<?>addrole(@RequestBody PermissionDto permissionDto)
	{
		try
		{
			permissionServiceInterface.addPermission(permissionDto);
			return new ResponseEntity<>(new SucessResponseDto("success","success","successfully added permission"),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto( "does not exit  ","permission id does not exit"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
   
    // get all permission with pagination 
    @GetMapping()
	public ResponseEntity<?> getAllusers(
			@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)
	 {
		
		Page<IPermissionListDto> entity= permissionServiceInterface.getAllPermission(search,pageNumber,pageSize);
		if(entity.getTotalElements()!=0)
		{
			return new ResponseEntity<>(entity.getContent(), HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
	    }
	}
    
    
    // get by permission id 
 	@GetMapping("/{id}")
 	public ResponseEntity<?>getPermissionid(@PathVariable Integer id)
 	{
 		try 
 		{
             PermissionDto permissionDto=this.permissionServiceInterface.getPermissionId(id);
 			return new ResponseEntity<>(new SucessResponseDto("Success","Success", permissionDto),HttpStatus.OK);
 		}catch(ResourceNotFoundException e) 
 		{
 			return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"permission Not Found"),HttpStatus.NOT_FOUND);
 		}
 	   }
    
 	
    // update by permission id 
 	@PutMapping("/{id}")
 	public ResponseEntity<?>updateByPermissionId(@RequestBody PermissionDto permissionDto,@PathVariable Integer id)
 	{
 		try
 		{
 			
 		  PermissionDto permissionDto1=this.permissionServiceInterface.updatepermission(permissionDto,id);
 		  return new ResponseEntity<>(new SucessResponseDto("update", "update sucessfully", permissionDto1),HttpStatus.OK);
 	
 		}catch(Exception e)
 		{
 			return new ResponseEntity<>(new ErrorResponseDto("Please Enter Valid PermissionId..", "Not Updated Data.."),HttpStatus.NOT_FOUND);
 		}
 			
 	}
 	
 	
    // delete by permission id 
 	@DeleteMapping("/{id}")
 	public ResponseEntity<?> deletepermission(@PathVariable Integer id)
 	{

 		try 
 		{
 			this.permissionServiceInterface.deletePermission(id);
 			return new  ResponseEntity<>(new SucessResponseDto("Success","Success", "Deleted Successfully!"),HttpStatus.OK);
 		}catch(ResourceNotFoundException e) 
 		{
            return new ResponseEntity<>( new ErrorResponseDto(e.getMessage(),"permission Not Found"),HttpStatus.NOT_FOUND);
 	    }
 	}
 	
 	
 	
 	
}
