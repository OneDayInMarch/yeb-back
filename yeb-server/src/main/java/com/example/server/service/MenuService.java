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

    List<Menu> getMenusByAdminId();
}
