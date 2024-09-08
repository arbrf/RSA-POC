package com.ct.calculator.ct_calculator_service.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ct.calculator.ct_calculator_service.hhtp.HttpRequest;
import com.ct.calculator.ct_calculator_service.hhtp.HttpRestTemplateEngine;
import com.ct.calculator.ct_calculator_service.pojo.InputRequestDTO;
import com.google.gson.Gson;

@Service
public class ApiCallService {
    @Autowired
	private HttpRestTemplateEngine httpRestTemplateEngine;
    private String url = "http://localhost:8081/calc/add";
    private  HttpMethod method = HttpMethod.POST;
	public ResponseEntity<String> executeCall(InputRequestDTO inputRequestDTO) {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		String json = gson.toJson(inputRequestDTO);
		HttpRequest httpRequest = new HttpRequest(url, json, method);
		httpRestTemplateEngine.execute(httpRequest);
		
		ResponseEntity<String> response = httpRestTemplateEngine.execute(httpRequest);
		return response;
		
	}

	
}
