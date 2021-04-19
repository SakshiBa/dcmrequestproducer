package com.somos.dcm.request.process;

import java.io.IOException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.somos.dcm.request.payload.CRRequest;
import com.somos.dcm.request.payload.JsonResponse;
import com.somos.dcm.request.transformer.RequestConstructor;
import com.somos.dcm.request.transformer.ScpRequestException;

@Component
public class ScpRequestBuilder {
	
	@Autowired
	RequestConstructor reqConstr;

	static Logger logger = LoggerFactory.getLogger(ScpRequestBuilder.class);


	/**
	 * Forms byte array formed for request received and sends it to request queue
	 * 
	 * @param msg
	 * @param exchange
	 * @return
	 * @throws ScpRequestException
	 */
	public JsonResponse requestBuilder(String msg)
			throws ScpRequestException, InstantiationException, NoSuchFieldException {
		ObjectMapper mapper = new ObjectMapper();
		CRRequest croJsonObject;
		JsonResponse response = new JsonResponse();
		try {
			croJsonObject = mapper.readValue(msg, CRRequest.class);
			logMessage(msg, croJsonObject);
			reqConstr.headerMessage(croJsonObject);
			
			ByteBuffer buff = stringToByteBuffer(msg);
			long byteSize = (long) buff.capacity();
			response.setCrByteSize(byteSize);
			logger.debug("Allocated byte size" + byteSize);
		} catch (ScpRequestException e) {
			logger.error(e.getMessage());
			response.setErrMsg(e.getMessage());
		} catch (IOException e) {
			logger.error(e.getMessage());
			response.setErrMsg("Internal error in transformation " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			response.setErrMsg("Unknown Exception in transformation " + e.getMessage());
		}
		return response;

	}

	/**
	 * Logs small JSON's
	 * 
	 * @param msg
	 * @param croJsonObject
	 */
	private void logMessage(String msg, CRRequest croJsonObject) {
		String loggerMsg = "Adapter receives the JSON ";
		if (null != msg) {
			logger.info(loggerMsg + msg);
		}
	}
	
	public static ByteBuffer stringToByteBuffer(String msg){
		byte[] b=msg.getBytes();
		return ByteBuffer.wrap(b);
	}

}
