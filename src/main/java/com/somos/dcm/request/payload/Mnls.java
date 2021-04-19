package com.somos.dcm.request.payload;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import lombok.Data;

/**
 * 
 * POJO for MNLS
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clli",
    "mnl"
})
@Data
public class Mnls {

    @JsonProperty("clli")
    public String clli;
    @JsonProperty("mnl")
    public List<Mnl> mnl = null;

}
