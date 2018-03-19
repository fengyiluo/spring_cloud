/**
 * com.gmq.tech.com
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gmq
 * @version $Id Service2Application.java, v 0.1 2018-03-18 22:27 gmq Exp $$
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@Deprecated
public class Service2Application {

    @GetMapping("/service2")
    public String service2() {
        return "service2";
    }

    public static void main(String[] args) {
        SpringApplication.run(Service2Application.class, args);
    }
}