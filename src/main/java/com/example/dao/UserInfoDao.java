package com.example.dao;

import com.example.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @ProjectName: springboot-shiro
 * @Package: com.example.dao
 * @ClassName: UserInfoDao
 * @Description:
 * @Author: Ni Shichao
 * @Version: 1.0
 */
public interface UserInfoDao extends CrudRepository<UserInfo,Long> {

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
