package com.coin.auth.web.dto;

import java.time.LocalDateTime;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* @ClassName SysRoleDto
* @Description: 
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRoleDto implements Serializable {

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
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除，0否，1是
     */
    private String isDelete;


}
