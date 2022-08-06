package com.example.server.service;

import com.example.server.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
public interface MenuService extends IService<Menu> {

    /**
     * 通过用户id查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
