package com.czxy.dao;

import com.czxy.domain.Metting;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface MettingMapper extends Mapper<Metting> {

    @Select("select * from tab_metting where metting_id=#{mettingId}")
    @Results({
            @Result(property = "user",many = @Many(select = "com.czxy.dao.UserMapper.findUserByUsername"),column = "username")
    })
    public Metting findMettingByMid(@Param("mettingId")Integer mettingId);
}
