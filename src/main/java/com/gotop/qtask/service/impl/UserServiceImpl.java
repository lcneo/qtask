package com.gotop.qtask.service.impl;

import com.gotop.qtask.dao.UserMapper;
import com.gotop.qtask.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public List<Map<String, Object>> userQueryAll() {
//        List<Map<String, Object>> lm =userMapper.userQueryAll();
        return userMapper.userQueryAll();
    }
}
