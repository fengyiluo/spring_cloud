/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author guominqiang
 * @version $Id SpringcloudEurekaSlaveServiceApplication.java, v 0.1 2018-03-19 20:43 guominqiang Exp $$
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringcloudEurekaSlaveServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaSlaveServiceApplication.class, args);
    }
}