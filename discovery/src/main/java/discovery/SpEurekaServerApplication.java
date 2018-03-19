/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 单点eureka server 启动类
 *
 * @author guominqiang
 * @version $Id SpEurekaServerApplication.java, v 0.1 2018-03-19 19:21 guominqiang Exp $$
 */
@SpringBootApplication
@EnableEurekaServer
public class SpEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpEurekaServerApplication.class, args);
    }
}