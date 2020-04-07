package com.coin.auth.web.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* @ClassName SysRolePermission
* @Description: 角色权限
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysRolePermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableField("ID")
    private String id;

    /**
     * 角色主键
     */
    @TableField("ROLE_ID")
    private String roleId;

    /**
     * 权限编码
     */
    @TableField("PERMISSION_CODE")
    private String permissionCode;

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
    // 需要加一个权限类型，绑定的角色是查看权限，还是授权权限
    // 角色应该是树形，上级有下级的所有权限


}
