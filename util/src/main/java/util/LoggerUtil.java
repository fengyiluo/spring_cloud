/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package util;

import org.slf4j.Logger;
import util.log.LogHolder;
import util.log.LogInfo;

import java.text.MessageFormat;

/**
 * 日志打印模版
 *
 * @author guominqiang
 * @version $Id LogUtil.java, v 0.1 2018-03-19 10:06 guominqiang Exp $$
 */
public class LoggerUtil {

    /**
     * <p>生成调试级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成debug级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger    logger应用
     * @param template  带参数的日志模版
     * @param paramters 参数集合
     */
    public static void debug(Logger logger, String template, Object... paramters) {
        if (logger.isDebugEnabled()) {
            logger.debug(getLogString(MessageFormat.format(template, paramters)));
        }
    }

    /**
     * <p>生成通知级别日志</p>
     * <p>
     * 根据待参数的日志模版很参数结合，生成info级别日志
     * 待参数的日志模版中以{数字}表示待替换为日志的变量点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger    logger应用
     * @param template  带参数的日志模版
     * @param paramters 参数集合
     */
    public static void info(Logger logger, String template, Object... paramters) {
        if (logger.isInfoEnabled()) {
            logger.info(getLogString(MessageFormat.format(template, paramters)));
        }
    }

    /**
     * <p>生成警告级别日志</p>
     * <p>
     * 根据待参数的日志模版很参数结合，生成info级别日志
     * 待参数的日志模版中以{数字}表示待替换为日志的变量点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger    logger应用
     * @param template  带参数的日志模版
     * @param paramters 参数集合
     */
    public static void warn(Logger logger, String template, Object... paramters) {
        if (logger.isWarnEnabled()) {
            logger.warn(getLogString(MessageFormat.format(template, paramters)));
        }
    }

    /**
     * <p>生成警告级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成warn级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param e          异常对象
     * @param logger     logger引用
     * @param template   带参数的日志模板
     * @param parameters 参数集合
     */
    public static void warn(Throwable e, Logger logger, String template, Object... parameters) {
        logger.warn(getLogString(MessageFormat.format(template, parameters)), e);
    }

    /**
     * <p>生成错误级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param logger     logger引用
     * @param template   带参数的日志模板
     * @param parameters 参数集合
     */
    public static void error(Logger logger, String template, Object... parameters) {
        logger.error(getLogString(MessageFormat.format(template, parameters)));
    }

    /**
     * <p>生成错误级别日志</p>
     * <p>
     * 根据带参数的日志模板和参数集合，生成error级别日志
     * 带参数的日志模板中以{数字}表示待替换为变量的日志点，如a={0}，表示用参数集合中index为0的参数替换{0}处
     * </p>
     *
     * @param e          异常对象
     * @param logger     logger引用
     * @param template   带参数的日志模板
     * @param parameters 参数集合
     */
    public static void error(Throwable e, Logger logger, String template, Object... parameters) {
        logger.error(getLogString(MessageFormat.format(template, parameters)), e);
    }


    /**
     * 生成输出日志
     *
     * @param logDetail 要输出日志的参数
     * @return
     */
    private static String getLogString(String logDetail) {
        StringBuffer log = new StringBuffer();
        log.append(logDetail)
                .append("; [")
                .append(getInvokeTraceInfo())
                .append("]");
        return log.toString();
    }

    /**
     * 获取日志追踪信息
     *
     * @return
     */
    private static String getInvokeTraceInfo() {
        LogInfo logInfo = LogHolder.getDigestInfo();
        String traceId = StringUtil.defaultIfBlank(logInfo.getUuid(),
                String.valueOf(logInfo.getStartTime()));
        traceId = StringUtil.defaultIfBlank(traceId, "-");
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("(");
        strBuffer.append(StringUtil.defaultIfBlank(logInfo.getAppName(), "-"));
        strBuffer.append(",");
        strBuffer.append(StringUtil.defaultIfBlank(logInfo.getMethodName(), "-"));
        strBuffer.append(",");
        strBuffer.append(traceId);
        strBuffer.append(",");
        strBuffer.append(fetchLoadTestStamp());
        strBuffer.append(")");
        return strBuffer.toString();
    }

    /**
     * 获取全链路压测标识
     *
     * @return 0：非全链路压测（正常业务）  1：全链路压测
     */
    private static String fetchLoadTestStamp() {

        return "0";
    }
}