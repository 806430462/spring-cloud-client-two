package com.yonyougov.servertwo.hystrix;

import org.springframework.stereotype.Service;

import com.yonyougov.servertwo.feign.FeignClientOne;

@Service
public class FeignClientOneFailure implements FeignClientOne {

	@Override
	public String query() {
		return "client one is not available !";
	}

}
