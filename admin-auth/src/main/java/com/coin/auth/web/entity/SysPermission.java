package com.coin.auth.web.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* @ClassName SysPermission
* @Description: 权限
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 编码
     */
    @TableField("CODE")
    private String code;

    /**
     * 上级编码
     */
    @TableField("P_CODE")
    private String pCode;

    /**
     * 名称
     */
    @TableField("NAME")
    private String name;

    /**
     * 链接
     */
    @TableField("URL")
    private String url;

    /**
     * 类型，0.模块，1.菜单,2.操作
     */
    @TableField("TYPE")
    private String type;

    /**
     * 顺序
     */
    @TableField("SEQ")
    private Integer seq;

    /**
     * 描述
     */
    @TableField("DESCRIPTION")
    private String description;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 是否删除，0否，1是
     */
    @TableField("IS_DELETE")
    private String isDelete;


}
