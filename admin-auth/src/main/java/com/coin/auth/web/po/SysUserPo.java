package com.coin.auth.web.po;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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
public class SysUserPo extends Page implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 姓名，真实
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String username;

    /**
     * 性别，0女，1男，2其他
     */
    private String sex;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 编码
     */
    private String code;

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

    private LocalDateTime createTimeStart;

    private LocalDateTime createTimeEnd;

    private LocalDateTime updateTimeStart;

    private LocalDateTime updateTimeEnd;
}
