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
    private int id;
    private int teacherId;
    private int courseId;
    private int laboratoryId;
}
