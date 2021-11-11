package com.mzw.hystrixpayment8001.service;

import com.mzw.mycommon.entity.GarbageCar;

/**
 * @PACKAGE_NAME: com.mzw.cloudproviderpayment8001.service
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
public interface GarbageCarService{


    String paymentOk(Integer id);

    String paymentTimeout(Integer id);

    String paymentCircuitBreaker(Long id);

}
