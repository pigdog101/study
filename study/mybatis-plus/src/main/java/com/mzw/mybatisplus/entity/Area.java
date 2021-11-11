package com.mzw.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * 区域表（街道、乡镇）
    */
@Data
@TableName(value = "garbage_area")
@NoArgsConstructor
public class Area {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    /**
     * 纬度
     */
    @TableField(value = "lat")
    private BigDecimal lat;

    /**
     * 经度
     */
    @TableField(value = "lon")
    private BigDecimal lon;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

    /**
     * 0正常1禁用-1删除
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 1街道2乡镇
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 历史排名
     */
    @TableField(value = "ranking")
    private Integer ranking;

    @TableField(value = "score",updateStrategy = FieldStrategy.IGNORED)
    private BigDecimal score;

    /**
     * 地图类型(1高德2天地图)
     */
    @TableField(value = "map_type")
    private Integer mapType;

    /**
     * 分数的更新
     */
    @TableField(value = "update_score")
    private BigDecimal updateScore;

    @TableField(value = "test")
    private String test;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_LAT = "lat";

    public static final String COL_LON = "lon";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    public static final String COL_STATUS = "status";

    public static final String COL_TYPE = "type";

    public static final String COL_RANKING = "ranking";

    public static final String COL_SCORE = "score";

    public static final String COL_MAP_TYPE = "map_type";

    public static final String COL_UPDATE_SCORE = "update_score";

    public static final String COL_TEST = "test";
}