package com.example.laboratory.controller;

import com.example.laboratory.entity.Laboratory;
import com.example.laboratory.entity.Role;
import com.example.laboratory.mapper.LaboratoryMapper;
import com.example.laboratory.mapper.RoleMapper;
import com.example.laboratory.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/admin/")
public class AdministratorController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private LaboratoryMapper laboratoryMapper;
     @PostMapping("addteacher")
    public ResultVO addTeacher(@RequestBody Role role){
        String password = passwordEncoder.encode(role.getPassword());
        Role role1 = Role.builder().name(role.getName()).authority(1).password(password).userName(role.getUserName()).build();
        roleMapper.insert(role1);
        List<Role>  roles = roleMapper.selectByMap(Map.of("authority",1));
        return ResultVO.success(Map.of("roles",roles));
    }
    @GetMapping("selectteacher")
    public ResultVO selectTeacher(){
        List<Role>  roles = roleMapper.selectByMap(Map.of("authority",1));
        return ResultVO.success(Map.of("roles",roles));
    }
    @GetMapping("deleteteacher/{id}")
    public ResultVO deleteTeacher(@PathVariable Long id){
        System.out.println("lll");
        roleMapper.deleteById(id);
        List<Role>  roles = roleMapper.selectByMap(Map.of("authority",1));
        return ResultVO.success(Map.of("roles",roles));
    }
    @PostMapping("updateteacher")
    public ResultVO updateTeacher(@RequestBody Role role){
        roleMapper.updateById(role);
        List<Role>  roles = roleMapper.selectByMap(Map.of("authority",1));
        return ResultVO.success(Map.of("roles",roles));
    }
    @PostMapping("addlaboratory")
    public ResultVO addLaboratory(@RequestBody Laboratory laboratory){
        System.out.println(laboratory);
        Laboratory laboratory1 = Laboratory.builder().name(laboratory.getName()).capacity(laboratory.getCapacity()).description(laboratory.getDescription()).build();
        laboratoryMapper.insert(laboratory1);
        List<Laboratory>  laboratories = laboratoryMapper.selectList(null);
        return ResultVO.success(Map.of("laboratories",laboratories));
    }
    @GetMapping("selectlaboratory")
    public ResultVO selectLaboratory(){
        List<Laboratory>  laboratories = laboratoryMapper.selectList(null);
        return ResultVO.success(Map.of("laboratories",laboratories));
    }
    @GetMapping("deletelaboratory/{id}")
    public ResultVO deleteLboratory(@PathVariable Long id){
        laboratoryMapper.deleteById(id);
        List<Laboratory>  laboratories = laboratoryMapper.selectList(null);
        return ResultVO.success(Map.of("laboratories",laboratories));
    }
    @PostMapping("updatelaboratory")
    public ResultVO updateLaboratory(@RequestBody Laboratory laboratory){
        System.out.println(laboratory);
        laboratoryMapper.updateById(laboratory);
        List<Laboratory>  laboratories = laboratoryMapper.selectList(null);
        return ResultVO.success(Map.of("laboratories",laboratories));
    }
}
