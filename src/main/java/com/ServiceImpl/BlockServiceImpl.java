package com.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ServiceInterface.BlockServiceInterface;

import com.entity.BlockList;
import com.repository.BlockRepository;

@Service
public class BlockServiceImpl implements BlockServiceInterface
{
   @Autowired
   private BlockRepository blockRepository;
   
   
  // block user 
  @Override
  public BlockList blockUser(BlockList  blockList) 
  {
	 BlockList block= new BlockList();
	 block.setBlockUser(blockList.getBlockUser());
	 
	 System.out.println("blockuser:"+blockList.getBlockUser());
	 block.setBlockedby(blockList.getBlockedby());
	 
	 return blockRepository.save(block);
	 
  }


   
}
