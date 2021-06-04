package com.example.laboratory.mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.laboratory.entity.Laboratory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface LaboratoryMapper extends BaseMapper<Laboratory> {
    @Select("select * from labreserve.laboratory where name>=#{number}")
    List<Laboratory> getAvailableLaboratory(@Param("number") int number);
}
