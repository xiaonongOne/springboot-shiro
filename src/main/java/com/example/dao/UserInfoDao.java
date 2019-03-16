package com.example.dao;

import com.example.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

/**
 * @ProjectName: springboot-shiro
 * @Package: com.example.dao
 * @ClassName: UserInfoDao
 * @Description:
 * @Author: Ni Shichao
 * @Version: 1.0
 */
public interface UserInfoDao extends CrudRepository<UserInfo,Integer> {

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);

    /**查询所有用户信息;*/
    public List<UserInfo> findAll();

    /**
     * 保存用户信息;
     */
    <S extends UserInfo> S save(S s);
    /**
     * 删除用户信息;
     */
    void delete(UserInfo var1);

    /**
     * 通过id查询用户信息;
     */
    Optional<UserInfo> findById(Integer id);
}
