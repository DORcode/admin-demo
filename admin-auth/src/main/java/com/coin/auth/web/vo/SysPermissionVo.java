package com.coin.auth.web.vo;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* @ClassName SysPermissionVo
* @Description: 权限
* @Author kh
* @Date 2020-02-27
* @Version V1.0
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysPermissionVo implements Serializable {

    private static final long serialVersionUID = 1L;

    public SysPermissionVo() {
    }

    public SysPermissionVo(String id, String code, String pCode,
                           String name, String url, String type, Integer seq) {
        this.id = id;
        this.code = code;
        this.pCode = pCode;
        this.name = name;
        this.url = url;
        this.type = type;
        this.seq = seq;
    }

    /**
     * 主键
     */
    private String id;

    /**
     * 编码
     */
    private String code;

    /**
     * 上级编码
     */
    @JsonProperty(value = "pCode")
    private String pCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接
     */
    private String url;

    /**
     * 类型，0.模块，1.菜单,2.操作
     */
    private String type;

    /**
     * 顺序
     */
    private Integer seq;

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

    private boolean selected;

    private String icon;

    private List<SysPermissionVo> subPerms;


}
