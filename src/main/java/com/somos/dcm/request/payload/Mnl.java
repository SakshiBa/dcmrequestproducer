package com.somos.dcm.request.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.Data;

/**
 * 
 *POJO for MNL
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "npa",
    "mnl"
})
@Data
public class Mnl {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("npa")
    public String npa;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("mnl")
    public List<MnlDetails> mnl = null;

}
