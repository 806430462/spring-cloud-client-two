package com.yonyougov.servertwo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yonyougov.servertwo.hystrix.FeignClientOneFailure;

@FeignClient(name="server-one",path="/server-one",fallback = FeignClientOneFailure.class)
public interface FeignClientOne {

    @RequestMapping(value="/test",method=RequestMethod.GET)
    String query();

}
