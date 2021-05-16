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
    private int id;
    private int capacity;
    private String description;
}
