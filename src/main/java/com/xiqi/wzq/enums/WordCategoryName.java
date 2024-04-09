package com.xiqi.wzq.enums;

import lombok.Getter;

/**
 * 单词分类
 */
@Getter
public enum WordCategoryName {
    Cet4("CET4")
    ;

    private final String category;

    WordCategoryName(String category) { this.category = category; }

    public static boolean isContains(String value) {
        for (WordCategoryName wordCategoryName : WordCategoryName.values()) {
            if (wordCategoryName.getCategory().equals(value)) {
                return true;
            }
        }
        return false;
    }
}
