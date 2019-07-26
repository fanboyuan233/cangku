package com.czxy.service;

import com.czxy.dao.MettingMapper;
import com.czxy.dao.RoomMapper;
import com.czxy.dao.UserMapper;
import com.czxy.domain.Metting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MettingService {
    @Autowired
    private MettingMapper mettingMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private UserService userService;

    public List<Metting> findAll(){
        Date nowDate=new Date();
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String nowdate = df.format(nowDate);

        Example example=new Example(Metting.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("status","未开始");
        criteria.andGreaterThanOrEqualTo("mettingStarttime",nowdate);
        List<Metting> list = mettingMapper.selectByExample(example);
        for (Metting metting : list) {
            metting.setRoom(roomMapper.selectByPrimaryKey(metting.getRoomId()));

        }
        return list;
    }


    public Metting findMettingByMid(Integer mettingId){
        Metting metting = mettingMapper.selectByPrimaryKey(mettingId);
        metting.setUser(userService.findUserByUsername(metting.getUsername()));
        return metting;
    }

    public List<Metting> findMetByUsername(String username){
        Example example=new Example(Metting.class);
        example.createCriteria().andEqualTo("username",username);
        List<Metting> mettings = mettingMapper.selectByExample(example);
        for (Metting metting : mettings) {
            metting.setRoom(roomMapper.selectByPrimaryKey(metting.getRoomId()));

        }
        return mettings;
    }
}
