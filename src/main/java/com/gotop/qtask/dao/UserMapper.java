package com.gotop.qtask.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    List<Map<String, Object>> userQueryAll();

}
