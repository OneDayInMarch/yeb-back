package com.example.server.service.impl;

import com.example.server.pojo.Admin;
import com.example.server.pojo.Menu;
import com.example.server.mapper.MenuMapper;
import com.example.server.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
//    public List<Menu> getMenusByAdminId() {
//        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
//        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
//        //查看redis 缓存中有没有数据
//        List<Menu> menus = (List<Menu>) valueOperations.get("menu_" + adminId);
//        if (CollectionUtils.isEmpty(menus)) {
//            //如果没有数据,数据库查询,并设置到缓存
//            menus = menuMapper.getMenusByAdminId(adminId);
//            valueOperations.set("menu_" + adminId, menus);
//        }
//        return menus;
//    }
    //不使用redis
    public List<Menu> getMenusByAdminId() {
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();//查看redis 缓存中有没有数据
        List<Menu> menus = menuMapper.getMenusByAdminId(adminId);
        return menus;
    }

    /**
     * 根据角色获取菜单列表
     *
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
        return baseMapper.getMenusWithRole();
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return baseMapper.getAllMenus();
    }
}
