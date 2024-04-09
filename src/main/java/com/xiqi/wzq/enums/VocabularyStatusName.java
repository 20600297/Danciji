package com.xiqi.wzq.enums;

import lombok.Getter;

/**
 * 表示单词背诵状态的枚举类
 *
 */
@Getter
public enum VocabularyStatusName {
    /**
     * 未背诵
     */
    Pending(-1),
    /**
     * 正在背诵
     */
    Active(0),
    /**
     * 已背诵
     */
    Completed(1)
    ;

    private final Integer status;

    VocabularyStatusName(Integer i) {
        status = i;
    }
}
