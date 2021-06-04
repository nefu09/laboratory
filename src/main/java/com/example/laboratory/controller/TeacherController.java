package com.example.laboratory.controller;

import com.example.laboratory.entity.Course;
import com.example.laboratory.entity.Role;
import com.example.laboratory.mapper.CourseMapper;
import com.example.laboratory.mapper.RoleMapper;
import com.example.laboratory.security.EncryptComponent;
import com.example.laboratory.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class TeacherController {

    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private CourseMapper courseMapper;
    @PostMapping("/login")
    public ResultVO login(@RequestBody Role role, HttpServletResponse response){
          Role role1 =  roleMapper.selectByUserName(role.getUserName());
        List<Role>  roles = roleMapper.selectByMap(Map.of("authority",1));
        if (role1 == null || !passwordEncoder.matches(role.getPassword(), role1.getPassword())) {
            return ResultVO.error(401, "用户名密码错误");
        }
          String result = encryptComponent.encrypt(Map.of("id",role1.getId(),"authority",role1.getAuthority()));
          response.addHeader("token",result);
        if (role1.getAuthority()==1) {
            return ResultVO.success(Map.of("role",1,"token",result));
        }
        else
        return ResultVO.success(Map.of("role",2,"token",result,"roles",roles));
    }
    @PostMapping("addcourse")
    public ResultVO addTeacher(@RequestBody Course course){

      Course course1 = Course.builder().name(course.getName()).studentNumber(course.getStudentNumber()).period(course.getPeriod()).build();
        courseMapper.insert(course1);
        List<Course> courses = courseMapper.selectList(null);
        return ResultVO.success(Map.of("courses",courses));
    }
    @GetMapping("selectcourse")
    public ResultVO selectTeacher(){
        List<Course> courses = courseMapper.selectList(null);
        return ResultVO.success(Map.of("courses",courses));
    }
    @GetMapping("deletecourse/{id}")
    public ResultVO deleteTeacher(@PathVariable Long id){
        courseMapper.deleteById(id);
        List<Course> courses = courseMapper.selectList(null);
        return ResultVO.success(Map.of("courses",courses));
    }
    @PostMapping("updatecourse")
    public ResultVO updateTeacher(@RequestBody Course course){
        courseMapper.updateById(course);
        List<Course> courses = courseMapper.selectList(null);
        return ResultVO.success(Map.of("courses",courses));
    }
}
