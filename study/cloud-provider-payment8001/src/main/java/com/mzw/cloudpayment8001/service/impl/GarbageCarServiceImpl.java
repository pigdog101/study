package com.mzw.cloudpayment8001.service.impl;

import com.mzw.mycommon.entity.GarbageCar;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.mzw.cloudpayment8001.dao.GarbageCarMapper;
import com.mzw.cloudpayment8001.service.GarbageCarService;
/** 
 * @PACKAGE_NAME: com.mzw.cloudproviderpayment8001.service.impl
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@Service
public class GarbageCarServiceImpl implements GarbageCarService{

    @Resource
    private GarbageCarMapper garbageCarMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return garbageCarMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(GarbageCar record) {
        return garbageCarMapper.insert(record);
    }

    @Override
    public int insertSelective(GarbageCar record) {
        return garbageCarMapper.insertSelective(record);
    }

    @Override
    public GarbageCar selectByPrimaryKey(Integer id) {
        return garbageCarMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(GarbageCar record) {
        return garbageCarMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(GarbageCar record) {
        return garbageCarMapper.updateByPrimaryKey(record);
    }

}
