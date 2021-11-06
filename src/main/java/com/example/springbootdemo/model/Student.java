package com.example.springbootdemo.model;

import com.example.springbootdemo.util.CustomDoubleSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生类
 *
 * @author lizhen created on 2021-11-03 15:04
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    @JsonSerialize(using = CustomDoubleSerialize.class)
    private Double price;
}
