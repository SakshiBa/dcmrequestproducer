package com.somos.dcm.request.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.jms.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
public class JmsConfig {
	
	Logger logger = LoggerFactory.getLogger(JmsConfig.class);
	
	@Value("${queue-name}")
	private String queueName;
	
	@Value("${environment}")
	private String envType;
	
	 @Bean
	    public Queue queue(){
		 	String queue=envType+'-'+queueName;
		 	logger.info("JmsConfig : Queue Name "+queue);
	        return new ActiveMQQueue(queue);
	    }

}
