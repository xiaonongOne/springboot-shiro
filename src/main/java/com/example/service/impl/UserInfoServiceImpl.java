package com.example.service.impl;

import com.example.dao.UserInfoDao;
import com.example.entity.UserInfo;
import com.example.entity.UserRegisteAndLogin;
import com.example.service.UserInfoService;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void save(UserInfo userInfo) {
        String password = userInfo.getPassword();
        String[] saltAndCiphertext = UserRegisteAndLogin.encryptPassword(userInfo.getUsername(),password);
        userInfo.setSalt(saltAndCiphertext[0]);
        userInfo.setPassword(saltAndCiphertext[1]);
        userInfo.setUid(2);
        userInfoDao.save(userInfo);
    }

    @Override
    public void delete(UserInfo userInfo) {
        userInfoDao.delete(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoDao.findAll();
    }

    @Override
    public UserInfo findById(Integer id) {
        Optional<UserInfo> op = userInfoDao.findById(id);
        return op.get();
    }


    @Override
    public void update(UserInfo userInfo) {
        UserInfo  us = userInfoDao.findById(userInfo.getUid()).get();
        us.setUsername(userInfo.getUsername());
        String[] saltAndCiphertext = UserRegisteAndLogin.encryptPassword(userInfo.getUsername(),userInfo.getPassword());
        us.setSalt(saltAndCiphertext[0]);
        us.setPassword(saltAndCiphertext[1]);
        userInfoDao.save(us);

    }


}
