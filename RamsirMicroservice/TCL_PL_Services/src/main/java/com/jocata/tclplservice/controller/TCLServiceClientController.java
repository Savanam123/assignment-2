package com.jocata.tclplservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.tclplservice.integration.CreateLeadClientService;
import com.jocata.tclplservice.integration.CreateWebtopClientService;
import com.jocata.tclplservice.integration.OtpEmailClientService;
import com.jocata.tclutils.request.CreateLeadRequest;
import com.jocata.tclutils.request.CreateWebtopRequest;
import com.jocata.tclutils.request.OtpEmailRequest;

@RestController
public class TCLServiceClientController {
	
	@Autowired
	OtpEmailClientService otpEmailClientService;
	
	@Autowired
	CreateLeadClientService createLeadClientService;
	
	@Autowired
	CreateWebtopClientService createWebtopClientService;
	
	@PostMapping("/otp/generateOtpByEmail")
	public ResponseEntity<?> generateOtpByEmail(@RequestBody OtpEmailRequest otpEmailRequest){		
		return otpEmailClientService.generateOTPByEmail(otpEmailRequest);
	}
	
	@PostMapping("/lead/createLead")
	public ResponseEntity<?> createLead(@RequestBody CreateLeadRequest createLeadRequest){		
		return createLeadClientService.createLead(createLeadRequest);
	}
	
	@PostMapping("/webtop/createWebtop")
	public ResponseEntity<?> createWebtop(@RequestBody CreateWebtopRequest createWebtopRequest){		
		return createWebtopClientService.createWebtop(createWebtopRequest);
	}

}
