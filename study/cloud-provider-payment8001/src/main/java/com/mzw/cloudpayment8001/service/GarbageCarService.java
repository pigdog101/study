package com.mzw.cloudpayment8001.service;

import com.mzw.mycommon.entity.GarbageCar;

/**
 * @PACKAGE_NAME: com.mzw.cloudproviderpayment8001.service
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
public interface GarbageCarService{


    int deleteByPrimaryKey(Integer id);

    int insert(GarbageCar record);

    int insertSelective(GarbageCar record);

    GarbageCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GarbageCar record);

    int updateByPrimaryKey(GarbageCar record);

}
