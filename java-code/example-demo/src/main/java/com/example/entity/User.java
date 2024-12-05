package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @auther wendongchao
 * @date 2024/12/2 00:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -1840831686851699943L;
    private Integer id;
    private String userId;
    private String userName;
}
