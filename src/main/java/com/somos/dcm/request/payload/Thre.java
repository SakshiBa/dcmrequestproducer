package com.somos.dcm.request.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sthre",
    "cthre"
})
@Data
public class Thre {
	
	/**
	 * 
	 * (Required)
	 * 
	 */
    @JsonProperty("sthre")
    private String sthre;
    @JsonProperty("cthre")
    private String cthre;
}
