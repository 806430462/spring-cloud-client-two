package com.yonyougov.servertwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yonyougov.servertwo.feign.FeignClientOne;

@RestController
public class TestController {

	@Autowired
	FeignClientOne feignClientTwo;

	@HystrixCommand(fallbackMethod = "serviceFailure")
	@RequestMapping("/test")
	public String test() {
		return "hello world!";
	}

	@RequestMapping("/client-two-test")
	public String clientTwoTest() {
		return feignClientTwo.query();
	}

	public String serviceFailure() {
		return "service fail !";
	}
}
