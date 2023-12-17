package com.practice;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardRepository {

	public int insertBoard(Board board);
	
}
