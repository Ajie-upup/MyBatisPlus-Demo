package com.ajie.pojo;

/**
 * @author ajie
 * @date 2023/5/17
 * @description:
 */

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
