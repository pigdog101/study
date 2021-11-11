package com.mzw.providerpayment8002.dao;

import com.mzw.mycommon.entity.GarbageCar;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PACKAGE_NAME: com.mzw.cloudproviderpayment8001.dao
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@Mapper
public interface GarbageCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GarbageCar record);

    int insertSelective(GarbageCar record);

    GarbageCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GarbageCar record);

    int updateByPrimaryKey(GarbageCar record);
}