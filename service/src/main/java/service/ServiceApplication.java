/**
 * com.gmq.tech.com
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmq
 * @version $Id ServiceApplication.java, v 0.1 2018-03-18 22:17 gmq Exp $$
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceApplication {

    @GetMapping("/service")
    public String service() {
        return "service";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }
}