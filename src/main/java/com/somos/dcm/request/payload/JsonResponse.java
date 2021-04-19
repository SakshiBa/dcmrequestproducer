package com.somos.dcm.request.payload;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> errMsg;
	private Long crByteSize;

	public void setErrMsg(String error) {
		if (null == errMsg) {
			errMsg = new ArrayList<String>();
		}
		errMsg.add(error);
	}
	
	public void setCrByteSize(Long byteSize){
		crByteSize =  byteSize;
	}
}