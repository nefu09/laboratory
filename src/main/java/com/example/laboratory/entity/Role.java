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
    private int id;
    private String password;
    private String name;
    private int authority;
}
