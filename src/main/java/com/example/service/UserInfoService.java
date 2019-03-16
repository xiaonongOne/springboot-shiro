package com.example.service;

import com.example.entity.UserInfo;

import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: springboot-shiro
 * @Package: com.example.service
 * @ClassName: UserInfoService
 * @Description:
 * @Author: Ni Shichao
 * @Version: 1.0
 */
public interface UserInfoService {

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
    /** 保存用户信息;*/
    public void save(UserInfo userInfo);
    /** 删除用户信息;*/
    public void delete(UserInfo userInfo);
    /** 删除用户信息;*/
    public List<UserInfo> findAll();
    /** 通过id查询用户信息;*/
    public UserInfo findById(Integer uid);
    /** 保存用户信息;*/
    public void update(UserInfo userInfo);
}
