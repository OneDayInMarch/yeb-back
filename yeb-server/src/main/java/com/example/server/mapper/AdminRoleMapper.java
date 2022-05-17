package com.example.server.mapper;

import com.example.server.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {
    Integer addRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
