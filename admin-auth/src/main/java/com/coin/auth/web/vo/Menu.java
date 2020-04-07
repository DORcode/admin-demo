package com.coin.auth.web.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

/**
 * @ClassName Menu
 * @Description: 菜单
 * @Author kh
 * @Date 2020/3/8 21:06
 * @Version V1.0
 **/
@Getter
@Setter
@ToString
public class Menu {
    private static final long serialVersionUID = 1L;

    public Menu() {
    }

    public Menu(String id, String code, String pCode,
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
    private String pCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 链接
     */
    @JSONField(name = "path")
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
     * 下级菜单
     */
    List<Menu> subMenus;

}
