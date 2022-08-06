package com.example.server.service;

import com.example.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.RespBean;
import com.example.server.pojo.Role;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
public interface AdminService extends IService<Admin> {
    //登录之后返回token
    RespBean login(String username, String password, String code, HttpServletRequest request);

    //根据用户名获取用户信息
    Admin getAdminByUserName(String username);

    /**
     * 根据用户ID查询角色列表
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 获取所有操作员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);


    /**
     * 更新用户密码
     * @param oldPass
     * @param pass
     * @param adminId
     * @return
     */
    RespBean updatePassword(String oldPass,String pass,Integer adminId);

    /**
     * 更新用户头像
     * @param url
     * @param id
     * @param authentication
     * @return
     */
    RespBean updateAdminUserFace(String url, Integer id, Authentication authentication);
    /**
     * 新增操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);
}