package com.coin.auth.web.po;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
* @ClassName SysRole
* @Description: 
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRolePo extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 描述
     */
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

    private LocalDateTime createTimeStart;

    private LocalDateTime createTimeEnd;

    private LocalDateTime updateTimeStart;

    private LocalDateTime updateTimeEnd;

}
