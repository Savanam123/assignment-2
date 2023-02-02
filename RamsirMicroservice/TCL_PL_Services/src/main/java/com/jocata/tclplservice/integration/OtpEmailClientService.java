package com.jocata.tclplservice.integration;

import java.util.Date;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jocata.tclutils.request.OtpEmailRequest;
import com.jocata.tclutils.response.OtpEmailResponse;


@Service
public class OtpEmailClientService {
	
	public ResponseEntity<?> generateOTPByEmail(@RequestBody OtpEmailRequest otpEmailRequest){
		
		OtpEmailResponse otpEmailResponse = new OtpEmailResponse();
		
		//process of calling third party TCL API
		//1. url to be called
		String otpByEmailUrl= "https://apicast-uat-jocatafrontendadapter.tclnprdservice.tatacapital.com/rest/jocata/v1.0/otp/generateOTPByEmail";
		
		//2. headers to be passed
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Accept-Encoding", "gzip,deflate");
		headers.add("Content-Type", "application/json");
		headers.add("Authorization", "Basic MTNlMzkxNzY6am9jYXRhdWF0");
		headers.add("ConversationID", "TCLPL_" + new Date().getTime());
		headers.add("SourceName", "Jocata");

		//3. preare the request body in jsonstring format to be passed
		ObjectMapper mapper = new ObjectMapper();
		String reqString = null;
		try {
			reqString = mapper.writeValueAsString(otpEmailRequest);//{"EmailId":"ram.darivemula@jocata.com"}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		JSONObject jsonReq = new JSONObject(reqString);
		//jsonReq.put("newKey", "newValue");
		
		//4. create httpentity obj with above headers and req body in json format
		HttpEntity<String> reqEntity = new HttpEntity<String>(jsonReq.toString(), headers);
		
		//5. create RestTemplate obj and pass the entity -> get the response and return		
		RestTemplate restCaller = new RestTemplate();
		otpEmailResponse = restCaller.postForObject(otpByEmailUrl, reqEntity, OtpEmailResponse.class);
		
		return new ResponseEntity<OtpEmailResponse>(otpEmailResponse, HttpStatus.OK);
	}

}
