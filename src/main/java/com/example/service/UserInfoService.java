package com.example.service;

import com.example.entity.UserInfo;

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
}
