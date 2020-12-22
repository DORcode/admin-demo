package com.coin.base.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName Order
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-22 16:59
 * @Version V1.0
 **/
@ApiModel(value = "公共-排序")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Order {
    @ApiModelProperty(value="字段名称", required=false)
    private String column;
    @ApiModelProperty(value="顺序，asc/desc", required=false)
    private String order;
}
