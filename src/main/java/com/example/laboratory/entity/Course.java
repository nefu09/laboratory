package com.example.laboratory.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("course")
public class Course {
    private String id;
    private String name;
    private Integer studentNumber;
    private Integer period;
}
