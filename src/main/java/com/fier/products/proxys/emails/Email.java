package com.fier.products.proxys.emails;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fier.products.modules.models.entity.emails.EmailModel;

@FeignClient(name = "emailsApi", url = "${email}")
public interface Email {

    @PostMapping(path = "")
    void sendEmailToUser(@RequestBody EmailModel email);
}
