package com.gdu.app011.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.app011.domain.AttachDTO;
import com.gdu.app011.domain.UploadDTO;

@Mapper
public interface UploadMapper {
	
	// getUploadList
	public List<UploadDTO> getUploadList();
	
	// addUpload
	public int addUpload(UploadDTO uploadDTO);
	public int addAttach(AttachDTO attachDTO);
	
	// geUploadByNo
	public UploadDTO getUploadByNo(int uploadNo);
	public List<AttachDTO> getAttachList(int uploadNo);
	
	// display
	public AttachDTO getAttachByNo(int attachNo);
}
