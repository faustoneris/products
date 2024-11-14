package com.fier.products.proxys.emails;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fier.products.modules.models.entity.products.Product;

@FeignClient(name = "emails-api", url = "${emails}")
public interface Email {

    @PostMapping(path = "api/{email}")
    void sendEmailToUser(@RequestBody Product product);
}
