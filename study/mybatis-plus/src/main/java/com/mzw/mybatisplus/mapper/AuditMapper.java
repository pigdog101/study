package com.mzw.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mzw.mybatisplus.entity.Audit;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuditMapper extends BaseMapper<Audit> {
}