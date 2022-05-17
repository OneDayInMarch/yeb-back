package com.example.server.service.impl;

import com.example.server.pojo.Role;
import com.example.server.mapper.RoleMapper;
import com.example.server.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
