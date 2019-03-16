package com.example.entity;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 *用户注册与登录时用到的函数
 */
public class UserRegisteAndLogin
{
    /**
     * 用户注册时加密用户的密码
     * 输入密码明文 返回密文与盐值
     * @param password
     * @return 第一个是密文  第二个是盐值
     */
    public static String[] encryptPassword(String username,String password)
    {
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex(); //生成盐值
        salt = username+salt;
        int hashIterations = 2;//加密的次数
        String hashAlgorithmName = "md5";//加密方式
        Object simpleHash = new SimpleHash(hashAlgorithmName, password,
                salt, hashIterations);
        String[] strings = new String[]{salt, simpleHash.toString()};
        return strings;
    }


}
