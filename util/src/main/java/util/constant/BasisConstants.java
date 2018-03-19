/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package util.constant;

import java.util.concurrent.TimeUnit;

/**
 * 基本常量
 *
 * @author guominqiang
 * @version $Id BasisConstants.java, v 0.1 2018-03-19 11:38 guominqiang Exp $$
 */
public class BasisConstants {

    /**
     * 对列的默认大小设置
     **/
    public static final int QUEUE_SIZE = 50000;

    /**
     * 队列的等待时间
     **/
    public static final long QUEUE_TIMEOUT = 10000;

    /**
     * 队列等待的时间单位
     **/
    public static final TimeUnit UNIT = TimeUnit.SECONDS;
}