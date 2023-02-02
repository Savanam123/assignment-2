package com.jocata.tclpl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.tclpl.service.OtpEmailServiceCaller;
import com.jocata.tclutils.request.OtpEmailRequest;



@RestController
@RequestMapping("/otp")
public class OtpController {
	
	@Autowired
	OtpEmailServiceCaller otpEmailServiceCaller;
	
	@PostMapping("/generateOtpByEmail")
	public ResponseEntity<?> generateOtpByEmail(@RequestBody OtpEmailRequest otpEmailRequest){
		
		return otpEmailServiceCaller.getOtpByEmail(otpEmailRequest);
	}

}
