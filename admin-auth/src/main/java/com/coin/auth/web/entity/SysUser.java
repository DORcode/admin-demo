package com.coin.auth.web.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* @ClassName SysUser
* @Description: 用户
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    public SysUser(String username) {
        this.username = username;
    }

    /**
     * 主键
     */
    @TableId("ID")
    private String id;

    /**
     * 姓名，真实
     */
    @TableField("NAME")
    private String name;

    /**
     * 密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 用户名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 性别，0女，1男，2其他
     */
    @TableField("SEX")
    private String sex;

    /**
     * 手机号
     */
    @TableField("MOBILE")
    private String mobile;

    /**
     * 编码
     */
    @TableField("CODE")
    private String code;

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
