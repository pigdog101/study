package com.mzw.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @PACKAGE_NAME: com.mzw.cloudproviderpayment8001.entity
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResult<T> {
    private Integer code;
    private String message;
    private T Data;

    public CommentResult(T t) {
        this.Data = t;
        code =  200;
        message = "成功";
    }
}
