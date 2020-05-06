package com.example;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "corona-ip", url = "https://corona-api.com/")
public interface CoronavirusService {

    @RequestMapping(value = "/timeline")
    Timeline timeline();

}
