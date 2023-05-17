package com.ajie.pojo;

/**
 * @author ajie
 * @date 2023/5/17
 * @description:
 */

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
// 该注解用来指定类在数据库中对应的表名
@TableName(value = "user")
public class User {

    // MP 封装有对字段的驼峰映射关系
    /**
     * 修改主键增长策略
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;

    /**
     * 设置字段自动赋值
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
}
