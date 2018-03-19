/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 客户端启动类
 *
 * @author guominqiang
 * @version $Id SpUserServiceMasterApplication.java, v 0.1 2018-03-19 16:17 guominqiang Exp $$
 */
@EnableDiscoveryClient //激活Eureka中的DiscoveryClient实现(自动化配置,创建DiscoveryClient接口针对Eureka客户端的EurekaDiscoveryClient实例)
@SpringBootApplication
public class SpUserServiceMasterApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpUserServiceMasterApplication.class, args);
    }
}