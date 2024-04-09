package com.xiqi.wzq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一的响应结果
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {

    // 状态码
    private Integer code;

    // 返回信息
    private String message;

    // 返回数据
    private T data;

    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    //快速返回操作成功响应结果
    public static Result success() {
        return new Result<>(0, "操作成功", null);
    }

    public static Result error(String message) {
        return new Result<>(1, message, null);
    }

}
