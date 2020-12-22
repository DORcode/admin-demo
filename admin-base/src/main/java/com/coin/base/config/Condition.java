package com.coin.base.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @ClassName Condition
 * @Description: TODO
 * @Author kh
 * @Date 2020-12-22 17:03
 * @Version V1.0
 **/
@ApiModel(value = "公共-搜索条件")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Condition {

    @ApiModelProperty(value="字段名称", required=false)
    private String column;
    @ApiModelProperty(value="查询条件", required=false)
    private String value;

    @ApiModelProperty(value="匹配规则", required=false, example = "" +
            "    | EQ        | 等于         | \"string\"、12.11 、\"YYYY-MM-DD HH:mm:ss\"、true |      |\n" +
            "    | NEQ       | 不等于       | \"string\"、12.11 、\"YYYY-MM-DD HH:mm:ss\"、true |      |\n" +
            "    | LIKE      | 包含         | \"string\"                                      |      |\n" +
            "    | GT        | 大于         | 12.11                                         |      |\n" +
            "    | GE        | 大于等于     | 12.11                                         |      |\n" +
            "    | HASONE    | 是否只有一个 |                                               |      |\n" +
            "    | LT        | 小于等于     | 12.11                                         |      |\n" +
            "    | LE        | 小于         | 12.11                                         |      |\n" +
            "    | ISNOTNULL | 不是空       |                                               |      |\n" +
            "    | ISNULL    | 是空         |                                               |      |\n" +
            "    | GTD       | 大于日期     | \"YYYY-MM-DD HH:mm:ss\"                         |      |\n" +
            "    | GED       | 大于等于日期 | \"YYYY-MM-DD HH:mm:ss\"                         |      |\n" +
            "    | LTD       | 小于日期     | \"YYYY-MM-DD HH:mm:ss\"                         |      |\n" +
            "    | LED       | 小于等于日期 | \"YYYY-MM-DD HH:mm:ss\"                         |      |\n" +
            "    | ALLIN     | 全包含       | \"xx,xx,xx,xx\"                                 |      |\n" +
            "    | IN        | 包含         | \"xx,xx,xx,xx\"")
    private String match;
}
