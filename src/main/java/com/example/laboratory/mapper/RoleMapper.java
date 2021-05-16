package com.example.laboratory.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.laboratory.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
