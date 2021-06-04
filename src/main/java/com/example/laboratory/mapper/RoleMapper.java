package com.example.laboratory.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.laboratory.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from  labreserve.role where user_name=#{user_name}")
    Role selectByUserName(@Param("user_name") String userName);
}
