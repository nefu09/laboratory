package com.example.laboratory.controller;

import com.example.laboratory.entity.Role;
import com.example.laboratory.mapper.RoleMapper;
import com.example.laboratory.security.EncryptComponent;
import com.example.laboratory.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@RestController
public class Controller01 {
    @Autowired
    private EncryptComponent encryptComponent;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleMapper roleMapper;
    @PostMapping("/login")
    public ResultVO login(@RequestBody Role role, HttpServletResponse response){
          Role role1 = roleMapper.selectById(role.getId());
        if (role1 == null || !passwordEncoder.matches(role.getPassword(), role1.getPassword())) {
            return ResultVO.error(401, "用户名密码错误");
        }
          String result = encryptComponent.encrypt(Map.of("id",role.getId(),"authority",role.getAuthority()));
          response.addHeader("token",result);
        System.out.println(result);
        return ResultVO.success(Map.of("data1",123456789));
    }
    @GetMapping("/test")
    public ResultVO test(){
        return ResultVO.success(Map.of("as",22));
    }
}
