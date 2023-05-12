package com.gdu.staff.util;

import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class PageUtil {
	
	private int page;              
	private int totalRecord;       
	private int recordPerPage;     
	private int begin;             
	private int end;              
	
	private int pagePerBlock = 5;  
	private int totalPage;         
	private int beginPage;         
	private int endPage;           
	
	public void setPageUtil(int page, int totalRecord, int recordPerPage) {
			
		
		this.page = page;
		this.totalRecord = totalRecord;
		this.recordPerPage = recordPerPage;
		
		begin = (page - 1) * recordPerPage + 1;
		end = begin + recordPerPage - 1;
		if(end > totalRecord) {
			end = totalRecord;
		}
		
		
		totalPage = totalRecord / recordPerPage;
		if(totalRecord % recordPerPage != 0) {
			totalPage++;
		}
		
		beginPage = ((page - 1) / pagePerBlock) * pagePerBlock + 1;
		endPage = beginPage + pagePerBlock - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}
}
