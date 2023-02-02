package com.jocata.tclpl.service;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jocata.tclutils.request.CreateWebtopRequest;
import com.jocata.tclutils.response.CreateWebtopResponse;

@Service
public class CreateWebtopServiceCaller {

	public CreateWebtopResponse createWebtop(CreateWebtopRequest createWebtopRequest) {
		
		CreateWebtopResponse createWebtopResponse = new CreateWebtopResponse();
		
		//process of calling client service layer generateOtpByEmail service
		//1. url to be called
		String otpByEmailUrl= "http://127.0.0.1:8090/tclplservices/webtop/createWebtop";
		
		//2. headers to be passed
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Accept-Encoding", "gzip,deflate");
		headers.add("Content-Type", "application/json");
		
		//3. preare the request body in jsonstring format to be passed
		ObjectMapper mapper = new ObjectMapper();
		String reqString = null;
		try {
			reqString = mapper.writeValueAsString(createWebtopRequest);//{"EmailId":"ram.darivemula@jocata.com"}
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		JSONObject jsonReq = new JSONObject(reqString);
				
		//4. create httpentity obj with above headers and req body in json format
		HttpEntity<String> reqEntity = new HttpEntity<String>(jsonReq.toString(), headers);
				
		//5. create RestTemplate obj and pass the entity -> get the response and return		
		RestTemplate restCaller = new RestTemplate();
		createWebtopResponse = restCaller.postForObject(otpByEmailUrl, reqEntity, CreateWebtopResponse.class);
		
		return createWebtopResponse;
		
	}
}
