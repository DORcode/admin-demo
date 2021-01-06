package com.coin.admintest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* @ClassName InfoBase
* @Description: 信息表
* @Author kh
* @Date 2020-10-20
* @Version V1.0
*/
public class InfoBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Integer typeCode;
    private Integer source;

    private LocalDateTime createTime;


    public String getId(String id) {
        return id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(Integer typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
