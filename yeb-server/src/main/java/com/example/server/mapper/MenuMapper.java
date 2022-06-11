package com.example.server.mapper;

import com.example.server.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
public interface MenuMapper extends BaseMapper<Menu> {
/**
 * 通过id查询菜单列表
 */
    List<Menu> getMenusByAdminId(Integer id);
}
