/**
 * com.gmq.tech.com
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 建立注册中心
 * @author gmq
 * @version $Id DiscoveryApplication.java, v 0.1 2018-03-18 22:09 gmq Exp $$
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
}