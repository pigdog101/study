package com.mzw.mybatisplus.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mzw.mybatisplus.entity.Audit;
import com.mzw.mybatisplus.mapper.AuditMapper;
import com.mzw.mybatisplus.service.AuditService;
@Service
public class AuditServiceImpl extends ServiceImpl<AuditMapper, Audit> implements AuditService{

}
