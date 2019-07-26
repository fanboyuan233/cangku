package com.czxy.service;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> login(User user){
        Example example=new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username",user.getUsername());
        criteria.andEqualTo("password",user.getPassword());
        List<User> list = userMapper.selectByExample(example);
        return list;
    }


    public User findUserByUsername(String username){
        Example example=new Example(User.class);
        example.createCriteria().andEqualTo("username",username);
        User user = userMapper.selectOneByExample(example);
        return user;
    }


}
