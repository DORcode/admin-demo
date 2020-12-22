package com.coin.base.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Page
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-22 16:55
 * @Version V1.0
 **/
@ApiModel(value = "公共-分页类")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Page {
    @ApiModelProperty(value="总数", required=false)
    private long total;
    @ApiModelProperty(value="页码", required=false)
    private long current;
    @ApiModelProperty(value="每页数量", required=false)
    private long size;
    @ApiModelProperty(value="排序", required=false)
    private List<Order> orders;
    @ApiModelProperty(value="条件查询", required=false)
    private List<Condition> conditions;

    public Page() {
        this.total = 0L;
        this.current = 1L;
        this.size = 10L;
        this.orders = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public Page(long current, long size) {
        this(0, current, size);
    }

    public Page(long total, long current, long size) {
        this.total = total;
        this.current = 1;
        if (current > 1) {
            this.current = current;
        }
        this.size = size;
        this.orders = new ArrayList<>();
        this.orders = new ArrayList<>();
    }
}
