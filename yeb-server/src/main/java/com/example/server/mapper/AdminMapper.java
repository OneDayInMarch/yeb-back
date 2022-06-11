package com.example.server.mapper;

import com.example.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
public interface AdminMapper extends BaseMapper<Admin> {
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
