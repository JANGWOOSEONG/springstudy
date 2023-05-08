package com.gdu.app011.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface UploadService {
	public int addUpload(MultipartHttpServletRequest multipartRequest);
}
