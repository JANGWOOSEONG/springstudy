package com.gdu.app011.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app011.domain.AttachDTO;

@Mapper
public interface UploadMapper {
	public int addAttach(AttachDTO attachDTO);
}
