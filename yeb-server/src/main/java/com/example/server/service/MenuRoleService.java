package com.example.server.service;

import com.example.server.pojo.MenuRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
public interface MenuRoleService extends IService<MenuRole> {

    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
