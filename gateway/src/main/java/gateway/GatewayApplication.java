/**
 * com.gmq.tech.com
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author gmq
 * @version $Id GatewayApplication.java, v 0.1 2018-03-18 22:37 gmq Exp $$
 */

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayApplication {


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
}