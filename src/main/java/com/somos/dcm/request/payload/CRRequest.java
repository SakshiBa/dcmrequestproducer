package com.somos.dcm.request.payload;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "num",
    "cmd",
    "msgType",
    "effDtTm",
    "cpr",
    "respOrgId",
    "msgId",
    "clliList",
    "slr",
    "slt",
    "isaType",
    "nmc",
    "mode",
    "mnls",
    "trc",
    "trv",
    "sml",
    "tml",
    "usr",
    "value",
    "mer",
    "lss",
  
})
@Component
@Data
public class CRRequest {

    @JsonProperty("num")
    private String num;
    @JsonProperty("cmd")
    private String cmd;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("msgType")
    private String msgType;
    @JsonProperty("effDtTm")
    private String effDtTm;
    @JsonProperty("cpr")
    private List<Cpr> cpr = null;
    @JsonProperty("respOrgId")
    private String respOrgId;
    @JsonProperty("mnls")
    public Mnls mnls;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("msgId")
    private String msgId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("clliList")
    private List<String> clliList = null;
    @JsonProperty("slr")
    private String slr;
    @JsonProperty("slt")
    private String slt;
    @JsonProperty("isaType")
    private String isaType;
    @JsonProperty("nmc")
    private String nmc;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("thre")
    private List<Thre> thre = null;
    @JsonProperty("giv")
    private String giv;
    private int byteSize;
    private String scpMessageType;
    private String priority;
    private String trc;
    private String trv;
    private String sml;
    private String tml;
    private String usr;
    private String value;
    private String mer;
    private String lss;
    private String cd;
    private String tp;
    private String gp;
    private String dr;
    private String tr;
    private String udata;
    @JsonProperty("cco")
    private String cco;
    private String nps;
    private String npt;
    private String npd;
    private String vcs;
    private String vct;
    private String vcd; 
    private String nlc;
    private String nso;
    private String drc;
    
    
    
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("num")
    public String getNum() {
        return num;
    }

    @JsonProperty("num")
    public void setNum(String num) {
        this.num = num;
    }


    @JsonProperty("effDtTm")
    public String getEffDtTm() {
        return effDtTm;
    }

    @JsonProperty("effDtTm")
    public void setEffDtTm(String effDtTm) {
        this.effDtTm = effDtTm;
    }

    @JsonProperty("cpr")
    public List<Cpr> getCpr() {
        return cpr;
    }

    @JsonProperty("cpr")
    public void setCpr(List<Cpr> cpr) {
        this.cpr = cpr;
    }

    @JsonProperty("respOrgId")
    public String getRespOrgId() {
        return respOrgId;
    }

    @JsonProperty("respOrgId")
    public void setRespOrgId(String respOrgId) {
        this.respOrgId = respOrgId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("msgId")
    public String getMsgId() {
        return msgId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("msgId")
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("clliList")
    public List<String> getClliList() {
        return clliList;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("clliList")
    public void setClliList(List<String> clliList) {
        this.clliList = clliList;
    }

    @JsonProperty("slr")
    public String getSlr() {
        return slr;
    }

    @JsonProperty("slr")
    public void setSlr(String slr) {
        this.slr = slr;
    }

    @JsonProperty("slt")
    public String getSlt() {
        return slt;
    }

    @JsonProperty("slt")
    public void setSlt(String slt) {
        this.slt = slt;
    }
     
}