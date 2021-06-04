package com.example.laboratory.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("laboratory")
public class Laboratory {
    private String id;
    private String name;
    private Integer capacity;
    private String description;
}
