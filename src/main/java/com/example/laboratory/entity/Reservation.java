package com.example.laboratory.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
@TableName("reservation")
public class Reservation {
    private String id;
    private String teacherId;
    private String courseId;
    private String laboratoryId;
    private int week;
    private int day;
    private int lesson;
}
