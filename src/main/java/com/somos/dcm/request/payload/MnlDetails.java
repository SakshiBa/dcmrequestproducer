package com.somos.dcm.request.payload;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


import lombok.Data;

/**
 * 
 *POJO for MNL details
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "nxx"
})
@Data
public class MnlDetails {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("status")
    public MnlDetails.Status status;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("nxx")
    public String nxx;

    public enum Status {

        N("N"),
        V("V"),
        D("D"),
        B("B");
        private final String value;
        private static final Map<String, MnlDetails.Status> CONSTANTS = new HashMap<String, MnlDetails.Status>();

        static {
            for (MnlDetails.Status c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static MnlDetails.Status fromValue(String value) {
            MnlDetails.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
