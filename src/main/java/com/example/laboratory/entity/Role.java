package com.example.laboratory.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("role")
public class Role {
    private String id;
    private String password;
    private String userName;
    private String name;
    private Integer authority;
}
