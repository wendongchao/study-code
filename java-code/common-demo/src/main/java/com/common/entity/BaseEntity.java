package com.common.entity;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @auther wendongchao
 * @date 2024/12/2 00:04
 **/
@Data
public class BaseEntity {
    private Timestamp createTime;// 创建时间
    private Timestamp updateTime;// 更新时间
}
