package com.utility;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Pagination 
{

	public Pageable getPagination(String pageNumber,String pageSize)
	{
		return  PageRequest.of(Integer.parseInt(pageNumber)-1, Integer.parseInt(pageSize));
	}

	public Pagination() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
}
