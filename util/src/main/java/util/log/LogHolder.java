/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package util.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.LoggerUtil;
import util.constant.LogConstants;

/**
 * @author guominqiang
 * @version $Id LogHolder.java, v 0.1 2018-03-19 11:12 guominqiang Exp $$
 */
public class LogHolder {
    /**
     * logger for this libary
     */
    protected final static Logger LOGGER = LoggerFactory.getLogger(LogConstants.COMMON_DIGEST_LOGGER_NAME);

    /**
     * ThreadLocal
     */
    private static ThreadLocal<LogInfo> digestInfoHolder = new ThreadLocal<LogInfo>();

    /**
     * 设置日志信息线程变量
     *
     * @param digestInfo 日志信息
     */
    public static void setDigestInfo(LogInfo digestInfo) {
        digestInfoHolder.set(digestInfo);
    }

    /**
     * 从线程中获取日志信息
     *
     * @return
     */
    public static LogInfo getDigestInfo() {
        LogInfo result = digestInfoHolder.get();
        if (null == result) {
            result = new LogInfo();
            result.setAppName("LocalHost");
            result.setMethodName(Thread.currentThread().getName());
            setDigestInfo(result);
        }
        return result;
    }

    /**
     * 清空本地线程变量
     */
    public static void clear() {
        digestInfoHolder.set(null);
    }

    /**
     * 复制线程中的日志变量
     *
     * @return 复制后的日志信息
     */
    public static LogInfo copyLogInfoInThread() {
        LogInfo logInfo = LogHolder.getDigestInfo();
        LogInfo logInfoCopy = null;
        try {
            logInfoCopy = logInfo.clone();
        } catch (CloneNotSupportedException e) {
            LoggerUtil.warn(LOGGER, "copy线程中日志出错");
            logInfoCopy = new LogInfo();
        }
        return logInfoCopy;
    }
}