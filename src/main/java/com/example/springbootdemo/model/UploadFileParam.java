package com.example.springbootdemo.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 文件上传
 *
 * @author lizhen created on 2021-10-21 15:33
 * @version 1.0
 */
@Data
public class UploadFileParam {

    /**
     * 图片
     */
    @NotEmpty(message = "图片不能为空")
    private List<MultipartFile> files;

    /**
     * 图片类型
     */
    @NotBlank(message = "图片类型不能为空")
    @Length(max = 2, message = "最多2个字符")
    private String picType;

    /**
     * token 令牌
     */
    @NotBlank(message = "token不能为空")
    @Length(min = 1, max = 50, message = "字段长度在1到50之间")
    private String token;

}
