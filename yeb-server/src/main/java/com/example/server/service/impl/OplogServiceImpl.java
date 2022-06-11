package com.example.server.service.impl;

import com.example.server.pojo.Oplog;
import com.example.server.mapper.OplogMapper;
import com.example.server.service.OplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements OplogService {

}
