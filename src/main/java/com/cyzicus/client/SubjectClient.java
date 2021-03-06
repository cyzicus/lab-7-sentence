package com.cyzicus.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${subjectService}")
public interface SubjectClient {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String getSubject();
}
