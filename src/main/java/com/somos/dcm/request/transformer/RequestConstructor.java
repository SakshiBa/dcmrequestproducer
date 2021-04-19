package com.somos.dcm.request.transformer;

import static com.somos.dcm.request.transformer.ScpRestConstants.ONE;
import static com.somos.dcm.request.transformer.ScpRestConstants.RTRV_ISA;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.somos.dcm.request.payload.CRRequest;
import com.somos.dcm.request.payload.Mnls;

@Component
public class RequestConstructor {
	
	Logger logger = LoggerFactory.getLogger(RequestConstructor.class);

	static Map<String, String> transformMap = new HashMap<String, String>();
	static {
		transformMap.put("UPD_UCR", "UCRRCU");
		transformMap.put("UPD_ROR", "URORRO");
		transformMap.put("RTRV_MNL", "GMNRRM");
		transformMap.put(RTRV_ISA, "GSARSA");
		transformMap.put("AUD_CPR", "ACRRCA");
		transformMap.put("UPD_MNL", "UMNRMN");
		transformMap.put("ENT_SSL", "USSRSS");
		transformMap.put("DLT_SSL", "USSRSS");
		transformMap.put("UPD_ETT", "UETRET");
		transformMap.put("UPD_ALP", "UALRAL");
		transformMap.put("RTRV_NCD", "GNCRNC");
		transformMap.put("UPD_DTT", "UDTRDT");
		transformMap.put("ENT_MCL", "UMLRML");
		transformMap.put("DLT_MCL", "UMLRML");
		transformMap.put("UPD_CCO", "UCORCO");
		transformMap.put("UPD_NMP", "NMPRNM");
	}

	/**
	 * Form the header
	 * 
	 * @param croJsonObject
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ScpRequestException
	 */
	public void headerMessage(CRRequest croJsonObject) throws ScpRequestException {
		
		String requestMsg = croJsonObject.getMsgType();
		String messageIdVal = croJsonObject.getMsgId();

		checkForMessageId(messageIdVal); 

		String patt;
		String messageId2;
		if (RTRV_ISA.equals(requestMsg)) {  
			patt = "^S[A-Za-z0-9]{9}$";
			messageId2 = "NODE";
		} else {
			patt = "^M[A-Za-z0-9]{9}$";
			messageId2 = "CMSD";
		}
		logger.debug("message type: " +messageId2);

		String priority = croJsonObject.getPriority();
		if (null == priority) {
			priority = "NOR";
		}
		patternCheck(messageIdVal, patt, "msgId"); //SB:VALIDATION CHECK

		getClliCode(requestMsg, croJsonObject);////SB:VALIDATION CHECK

			String messId; ////SB:VALIDATION CHECK,transformMap REQD
			if (transformMap.containsKey(requestMsg)) {
				messId = transformMap.get(requestMsg);
			} else {
				throw new ScpRequestException("msgType provided " + requestMsg + " is not supported");
			}
	}

	protected void patternCheck(String value, String patt, String param) throws ScpRequestException {
		Pattern pattern = Pattern.compile(patt);
		Matcher m = pattern.matcher(value);
		if (!m.find()) {
			throw new ScpRequestException(param + " " + value + " is not valid");
		}
	}

	private void checkForMessageId(String messageIdVal) throws ScpRequestException {
		if (null == messageIdVal) {
			throw new ScpRequestException("Missing mandatory parameter msgId");
		}

	}

	/**
	 * Gets clli code
	 * 
	 * @param requestMsg
	 * @param croJsonObject
	 * @return
	 * @throws ScpRequestException
	 */
	private List<String> getClliCode(String requestMsg, CRRequest croJsonObject) throws ScpRequestException {
		List<String> clliCodeList = croJsonObject.getClliList();
		if ("UPD_MNL".equals(requestMsg)) {
			Mnls mnls = croJsonObject.getMnls();
			if (null == mnls) {
				throw new ScpRequestException("Missing mandatory parameter mnls");
			}
			String clli = mnls.getClli();
			if (null == clli) {
				throw new ScpRequestException("Missing mandatory parameter clli");
			}
			clliCodeList = new ArrayList<String>();
			clliCodeList.add(clli);
		} else if (null == clliCodeList || clliCodeList.isEmpty()) {
			throw new ScpRequestException("Missing mandatory parameter clliList/clli");
		} else if ((RTRV_ISA.equals(requestMsg) || "RTRV_MNL".equals(requestMsg)) && clliCodeList.size() > ONE) {
			throw new ScpRequestException("Multiple clli codes are not allowed in " + requestMsg);
		}
		return clliCodeList;
	}
}