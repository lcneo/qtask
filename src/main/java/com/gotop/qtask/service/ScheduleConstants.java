package com.gotop.qtask.service;

/**
 * 任务调度通用常量
 * @author neo
 * @date 2019/12/8 - 17:30
 */
public interface ScheduleConstants {
    public static final String TASK_CLASS_NAME = "TASK_CLASS_NAME";

    /** 执行目标Key **/
    public static final String TASK_PROPERTIES = "TASK_PROPERTIES";

    /** 默认 **/
    public static final String MISFIRE_DEFAULT = "0";

    /** 立即触发执行 **/
    public static final String MISFIRE_IGNORE_MISFIRES = "1";

    /** 触发一次执行 **/
    public static final String MISFIRE_FIRE_AND_PROCEED = "2";

    /** 不立即触发 **/
    public static final String MISFIRE_DO_NOTHING = "3";

    public enum Status{
        /** 正常 **/
        NORMAL("0"),

        /** 暂停 **/
        PAUSE("1");

        private String value;

        private Status(String value){
            this.value = value;
        }

        public String getValue(){
            return value;
        }
    }
}