package com.example.springbootdemo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 商户注册查询DTO
 *
 * @author lizhen created on 2021-10-22 11:48
 * @version 1.0
 */
@Data
public class RegisterQueryDTO {
    
    /**
     * 	已注册用户号（usercode与merchant_no必填一个）
     */
    @Length(min = 1, max = 20, message = "字符长度在1~20之间")
    private String userCode;
    
    /**
     * 平台商的用户号（usercode与merchant_no必填一个）
     */
    @Length(max = 50, message = "最多50个字符")
    private String merchantNo;
}
