package com.xiqi.wzq.enums;

import lombok.Getter;


/**
 * 用于切换线程池
 */
@Getter
public enum AsyncBeanName {

    MYASYNC("myAsync"),
    SERVICE("scheduledExecutorService"),
    ;
    private final String str;

    AsyncBeanName(String s) {
        str = s;
    }
}
