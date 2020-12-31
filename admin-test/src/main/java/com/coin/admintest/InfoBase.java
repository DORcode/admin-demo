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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InfoBase implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String title;

    private String summary;
    private String content;

    private String author;
    private Integer typeCode;

    private String type;
    private Integer source;

    private String indexNumber;

    private String issuedNumber;

    private String subject;

    private String genre;

    private String issuingAgency;

    private String description;

    private String keywords;

    private String picAddress;

    private String userId;

    private Integer hits;

    private Integer isDelete;

    private LocalDateTime createTime;

    private LocalDateTime releaseTime;
    private LocalDateTime endTime;

    private LocalDateTime updateTime;
}
