package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceInterface.BlockServiceInterface;
import com.dto.BlockListDto;
import com.entity.BlockList;
import com.repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockServiceInterface
{
   @Autowired
   private BlockRepository blockRepository;
   
   
  // block user 
  @Override
  public BlockListDto blockUser(BlockListDto  blockListDto) 
  {
	 BlockList block= new BlockList();
     block.setBlockUser(blockListDto.getBlockUser());
	 blockRepository.save(block);
	 return blockListDto;
	
  }


   
}
