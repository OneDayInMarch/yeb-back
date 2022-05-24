package com.example.server.mapper;

import com.example.server.pojo.Role;
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
public interface RoleMapper extends BaseMapper<Role> {
    List<Role> getRolesByAdminId(Integer adminId);
}
