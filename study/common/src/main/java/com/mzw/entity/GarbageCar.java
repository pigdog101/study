package com.mzw.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * @PACKAGE_NAME: com.mzw.cloudproviderpayment8001.entity
 * @AUTHOR: mzw
 * @DATE: 2021/9/21
 */
@Data
@Builder
public class GarbageCar {
    private Integer id;

    /**
     * 车牌
     */
    private String carNumber;

    /**
     * 车辆类型
     */
    private String carTypeName;

    /**
     * 车辆类型id对应dictid
     */
    private Integer carTypeId;

    private String principle;

    private String phone;

    private Integer organizationId;

    /**
     * 所属公司
     */
    private String organizationName;

    /**
     * 保险公司
     */
    private String insuranceCompany;

    private Date gmtModified;

    private Date gmtCreate;

    /**
     * 0正常1禁用-1删除
     */
    private Integer status;

    /**
     * 第三方车辆id
     */
    private Integer qxId;

    private String source;

    private String frameNumber;

    private String engineNumber;

    private String drivingLicense;

    private String loadCapacity;

    private String powerType;

    private String garbageType;

    private String driver;

    private String idCard;

    private String driverLicense;
}