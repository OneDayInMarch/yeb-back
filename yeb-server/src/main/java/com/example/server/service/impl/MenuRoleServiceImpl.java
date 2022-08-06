package com.example.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.server.pojo.MenuRole;
import com.example.server.mapper.MenuRoleMapper;
import com.example.server.pojo.RespBean;
import com.example.server.service.MenuRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Zeng
 * @since 2022-03-26
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements MenuRoleService {

    /**
     * 更新角色菜单
     *
     * @param rid
     * @param mids
     * @return 方法： 1、删除此角色所有菜单；2、给该角色重新加上菜单；因是两步操作，开启事务
     */
    @Override
    @Transactional // 开启事务
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        // 如果调用此接口，没传其它参数，证明是删除已有菜单
        baseMapper.delete(new QueryWrapper<MenuRole>().eq("rid", rid));
        if (null == mids || 0 == mids.length) {
            return RespBean.success("更新成功！");
        }
        // 如果传参过来，新建批量更新方法，更新角色菜单
        Integer resule = baseMapper.insertRecord(rid, mids);
        if (resule == mids.length) {
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }
}
