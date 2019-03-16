package com.example.controller;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: springboot-shiro
 * @Package: com.example.controller
 * @ClassName: UserInfoController
 * @Description:
 * @Author: Xiao nong
 * @Version: 1.0
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 用户查询.
     * @return
     */
    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(Map map){
        List<UserInfo> list = userInfoService.findAll();
        map.put("list",list);
        return "userInfo";
    }

    /**
     * 跳转用户添加页面
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "userInfoAdd";
    }


    /**
     * 添加用户
     * @return
     */
    @RequestMapping("/userSave")
    @RequiresPermissions("userInfo:save")//权限管理;
    public String userSave(UserInfo user){
        userInfoService.save(user);
        return "redirect:userList";
    }
    /**
     * 用户删除;
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")//权限管理;
    public String userDel(UserInfo user){
        userInfoService.delete(user);
        return "redirect:userList";
    }

    /**
     * 跳转到编辑页面
     * @return
     */
    @RequestMapping("/userModifyInfo")
    @RequiresPermissions("userInfo:mdoifyInfo")//权限管理;
    public String userinfoModifyInfo(UserInfo userinfo,Map map){
        UserInfo userInfo = userInfoService.findById(userinfo.getUid());
        map.put("user",userInfo);
        return "userinfoModify";
    }

    /**
     * 修改用户信息
     * @return
     */
    @RequestMapping("/userModify")
    @RequiresPermissions("userInfo:modify")//权限管理;
    public String modify(UserInfo user){
        userInfoService.update(user);
        return "redirect:userList";
    }
}
