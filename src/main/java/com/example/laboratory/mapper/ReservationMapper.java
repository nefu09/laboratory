package com.example.laboratory.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.laboratory.entity.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ReservationMapper extends BaseMapper<Reservation> {
}
