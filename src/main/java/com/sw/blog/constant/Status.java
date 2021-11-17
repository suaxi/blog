package com.sw.blog.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Wang Hao
 * @date 2021/11/17 13:56
 */
@Getter
@AllArgsConstructor
public enum Status {

    /**
     * 待审核
     */
    PENDING_REVIEW("PENDING_REVIEW", "待审核"),

    /**
     * 未通过
     */
    NOT_PASS("NOT_PASS", "未通过"),

    /**
     * 通过
     */
    PASS("PASS", "通过");

    private String code;
    private String name;

    public static Status parseOf(String code) {
        for (Status item : values()) {
            if (item.getCode().equalsIgnoreCase(code)) {
                return item;
            }
        }
        throw new IllegalArgumentException("代号[" + code + "]不匹配");
    }
}
