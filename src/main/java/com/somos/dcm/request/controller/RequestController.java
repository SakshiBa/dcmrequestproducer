package com.somos.dcm.request.controller;

import javax.jms.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.somos.dcm.request.payload.JsonResponse;
import com.somos.dcm.request.process.ScpRequestBuilder;
import com.somos.dcm.request.transformer.ScpRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/dcm")
public class RequestController {
	
	Logger logger = LoggerFactory.getLogger(RequestController.class);

	@Autowired
	private Queue queue;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	ScpRequestBuilder factory;

	@PostMapping(value = "adapter/request", consumes = "application/json")
	public ResponseEntity<JsonResponse> addRequestInQueue(@RequestBody String scpReqMsg)
			throws InstantiationException, NoSuchFieldException, ScpRequestException {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		JsonResponse req = factory.requestBuilder(scpReqMsg);
		if (null == req.getErrMsg()) {
			status = HttpStatus.OK;
			jmsTemplate.convertAndSend(queue, scpReqMsg);
			logger.debug("RequestController : Request added in the queue ");
		} else {
			logger.debug("RequestController : Unable to add Request in the queue ");
		}
		return new ResponseEntity<JsonResponse>(req, status);
	}

}
