/**
 * sf.gmq.net
 * Copyright (C) 2012-2018 All Rights Reserved.
 */
package util.log;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 日志信息
 *
 * @author guominqiang
 * @version $Id LogInfo.java, v 0.1 2018-03-19 11:09 guominqiang Exp $$
 */
public class LogInfo {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 407851037032923018L;

    /**
     * 服务接口名称
     */
    private String facadeName;

    /**
     * 服务方法
     */
    private String methodName;

    /**
     * 服务开始时间
     */
    private final long startTime = System.currentTimeMillis();

    /**
     * 服务结束时间
     */
    private long endTime;

    /**
     * 操作类型
     */
    private boolean isQueryFunc;

    /**
     * 是否抛出异常
     */
    private boolean exceptional;

    /**
     * 是否调用服务失败
     */
    private boolean isFailure;

    /**
     * 返回错误码
     */
    private String errorCode;

    /**
     * 返回错误信息
     */
    private String errorMsg;

    /**
     * 调用参数
     */
    private Object[] args;

    /**
     * 调用方应用名
     */
    private String appName;

    /**
     * UUID
     */
    private String uuid;

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


    /**
     * @see java.lang.Object#clone()
     */
    @Override
    public LogInfo clone() throws CloneNotSupportedException {
        return (LogInfo) super.clone();
    }

    /**
     * 获取服务消耗时间
     *
     * @return 服务消耗时间
     */
    public long getElapseTime() {
        this.endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    /**
     * Getter method for property <tt>serialVersionUID</tt>.
     *
     * @return property value of serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Getter method for property <tt>facadeName</tt>.
     *
     * @return property value of facadeName
     */
    public String getFacadeName() {
        return facadeName;
    }

    /**
     * Setter method for property <tt>facadeName</tt>.
     *
     * @param facadeName value to be assigned to property facadeName
     */
    public void setFacadeName(String facadeName) {
        this.facadeName = facadeName;
    }

    /**
     * Getter method for property <tt>methodName</tt>.
     *
     * @return property value of methodName
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Setter method for property <tt>methodName</tt>.
     *
     * @param methodName value to be assigned to property methodName
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Getter method for property <tt>startTime</tt>.
     *
     * @return property value of startTime
     */
    public long getStartTime() {
        return startTime;
    }

    /**
     * Getter method for property <tt>endTime</tt>.
     *
     * @return property value of endTime
     */
    public long getEndTime() {
        return endTime;
    }

    /**
     * Setter method for property <tt>endTime</tt>.
     *
     * @param endTime value to be assigned to property endTime
     */
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    /**
     * Getter method for property <tt>isQueryFunc</tt>.
     *
     * @return property value of isQueryFunc
     */
    public boolean isQueryFunc() {
        return isQueryFunc;
    }

    /**
     * Setter method for property <tt>isQueryFunc</tt>.
     *
     * @param isQueryFunc value to be assigned to property isQueryFunc
     */
    public void setQueryFunc(boolean queryFunc) {
        isQueryFunc = queryFunc;
    }

    /**
     * Getter method for property <tt>exceptional</tt>.
     *
     * @return property value of exceptional
     */
    public boolean isExceptional() {
        return exceptional;
    }

    /**
     * Setter method for property <tt>exceptional</tt>.
     *
     * @param exceptional value to be assigned to property exceptional
     */
    public void setExceptional(boolean exceptional) {
        this.exceptional = exceptional;
    }

    /**
     * Getter method for property <tt>isFailure</tt>.
     *
     * @return property value of isFailure
     */
    public boolean isFailure() {
        return isFailure;
    }

    /**
     * Setter method for property <tt>isFailure</tt>.
     *
     * @param isFailure value to be assigned to property isFailure
     */
    public void setFailure(boolean failure) {
        isFailure = failure;
    }

    /**
     * Getter method for property <tt>errorCode</tt>.
     *
     * @return property value of errorCode
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Setter method for property <tt>errorCode</tt>.
     *
     * @param errorCode value to be assigned to property errorCode
     */
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * Getter method for property <tt>errorMsg</tt>.
     *
     * @return property value of errorMsg
     */
    public String getErrorMsg() {
        return errorMsg;
    }

    /**
     * Setter method for property <tt>errorMsg</tt>.
     *
     * @param errorMsg value to be assigned to property errorMsg
     */
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    /**
     * Getter method for property <tt>args</tt>.
     *
     * @return property value of args
     */
    public Object[] getArgs() {
        return args;
    }

    /**
     * Setter method for property <tt>args</tt>.
     *
     * @param args value to be assigned to property args
     */
    public void setArgs(Object[] args) {
        this.args = args;
    }

    /**
     * Getter method for property <tt>appName</tt>.
     *
     * @return property value of appName
     */
    public String getAppName() {
        return appName;
    }

    /**
     * Setter method for property <tt>appName</tt>.
     *
     * @param appName value to be assigned to property appName
     */
    public void setAppName(String appName) {
        this.appName = appName;
    }

    /**
     * Getter method for property <tt>uuid</tt>.
     *
     * @return property value of uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Setter method for property <tt>uuid</tt>.
     *
     * @param uuid value to be assigned to property uuid
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}