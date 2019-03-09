package com.example.service.impl;

import com.example.dao.UserInfoDao;
import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ProjectName: springboot-shiro
 * @Package: com.example.service.impl
 * @ClassName: UserInfoServiceImpl
 * @Description:
 * @Author: Ni Shichao
 * @Version: 1.0
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}
