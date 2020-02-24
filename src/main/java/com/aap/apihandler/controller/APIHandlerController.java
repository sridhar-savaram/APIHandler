package com.aap.apihandler.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aap.apihandler.repository.APIHandlerRepository;


@RestController
@RequestMapping(value = "/api")
public class APIHandlerController {
	
	@Autowired
	APIHandlerRepository apiHandlerRepo;

    private static final Logger logger = LoggerFactory.getLogger(APIHandlerController.class);    
        
    @PostMapping(value="/process", consumes = "text/plain", produces = "text/plain")
    public ResponseEntity<String> process(@RequestBody String payload, @RequestParam("interfaceCode") String interfaceCode){
    	String result = apiHandlerRepo.processAPI(interfaceCode, payload);
    	return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
