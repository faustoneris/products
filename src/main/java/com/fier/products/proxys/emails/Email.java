package com.fier.products.proxys.emails;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "beneficiarioAPI", url = "${gestaoidentidade-api.server}")
public interface Email {

}
