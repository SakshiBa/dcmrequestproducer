package com.somos.dcm.request.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "nodeType", "nodeName", "nodeValue", "child", "qualifier" })
@Data
public class Cpr {

	/**
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("nodeType")
	private String nodeType;
	@JsonProperty("nodeName")
	private String nodeName;
	@JsonProperty("nodeValue")
	private List<String> nodeValue = null;
	@JsonProperty("child")
	private List<Cpr> child = null;
	@JsonProperty("qualifier")
	private List<String> qualifier = null;

}
