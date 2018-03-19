/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 使用Ribbon实现客户端负载均衡
 * @author guominqiang
 * @version $Id SpH5RibbonHystrixApplication.java, v 0.1 2018-03-19 20:06 guominqiang Exp $$
 */
@SpringBootApplication
public class SpH5RibbonHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpH5RibbonHystrixApplication.class, args);
    }
}