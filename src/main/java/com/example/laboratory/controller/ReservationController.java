package com.example.laboratory.controller;

import com.example.laboratory.entity.Course;
import com.example.laboratory.entity.Laboratory;
import com.example.laboratory.entity.Reservation;
import com.example.laboratory.mapper.CourseMapper;
import com.example.laboratory.mapper.LaboratoryMapper;
import com.example.laboratory.mapper.ReservationMapper;
import com.example.laboratory.mapper.RoleMapper;
import com.example.laboratory.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/reserve/")
public class ReservationController {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private LaboratoryMapper laboratoryMapper;
    @Autowired
    private ReservationMapper reservationMapper;
    @GetMapping("{courseid}")
    public ResultVO checkAvailableLaboratory(@PathVariable("courseid") int id){
        Course course = courseMapper.selectById(id);
        List<Laboratory> laboratories = laboratoryMapper.getAvailableLaboratory(course.getStudentNumber());
        return ResultVO.success(Map.of("AvialableLaboratories",laboratories));
    }
    @GetMapping("{laboratoryid}")
    public ResultVO checkLaboratory(@PathVariable("laboratoryid") int id){
        List<Reservation> reservations= reservationMapper.selectByMap(Map.of("laboratoryId", id));
        return ResultVO.success(Map.of("reservations",reservations));
    }
    @GetMapping("reservetime")
    public ResultVO reserveTime(@RequestBody List<Reservation> reservations){
        reservations.forEach(r->{
            reservationMapper.insert(r);
        });
        return ResultVO.success(Map.of("message","选课成功"));
    }
}
