package com.cyzicus.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${verbService}")
public interface VerbClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getVerb();
}
