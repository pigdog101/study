package com.mzw.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "garbage_audit")
@NoArgsConstructor
public class Audit {
    @TableId(value = "id", type = IdType.INPUT)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "id_card")
    private String idCard;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "type")
    private Integer type;

    @TableField(value = "identity")
    private String identity;

    @TableField(value = "photo")
    private String photo;

    @TableField(value = "gmt_create")
    private Date gmtCreate;

    @TableField(value = "gmt_modified")
    private Date gmtModified;

    @TableField(value = "status")
    private Integer status;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_ID_CARD = "id_card";

    public static final String COL_PHONE = "phone";

    public static final String COL_TYPE = "type";

    public static final String COL_IDENTITY = "identity";

    public static final String COL_PHOTO = "photo";

    public static final String COL_GMT_CREATE = "gmt_create";

    public static final String COL_GMT_MODIFIED = "gmt_modified";

    public static final String COL_STATUS = "status";
}