package com.coin.auth.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coin.auth.web.vo.Menu;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TreeUtil
 * @Description: TODO
 * @Author kh
 * @Date 2020/3/9 19:23
 * @Version V1.0
 **/
public class TreeUtil {

    public static List<Menu> getMenuTree(List<Menu> list) {
        List<Menu> menus = new ArrayList<>();
        for(Menu m : list) {
            if(StringUtils.isEmpty(m.getPCode())) {
                Menu temp = new Menu();
                BeanUtil.copyProperties(temp, m);
                temp.setSubMenus(getChildMenu(list, m));
                menus.add(temp);
            }
        }
        return menus;
    }

    private static List<Menu> getChildMenu(List<Menu> list, Menu menu) {
        List<Menu> subMenus = new ArrayList<>();
        for(Menu m : list) {
            if(menu.getCode().equals(m.getPCode())) {
                m.setSubMenus(getChildMenu(list, m));
                subMenus.add(m);
            }
        }
        return subMenus;
    }

    public static void main(String[] args) {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("1", "1", null, "生产", null, "0", 1));
        menus.add(new Menu("2", "2", null, "消费", null, "0", 2));
        menus.add(new Menu("3", "3", null, "管理", null, "0", 3));
        menus.add(new Menu("4", "4", null, "工厂", null, "0", 4));

        menus.add(new Menu("5", "1001", "1", "生产水果", null, "0", 1));
        menus.add(new Menu("6", "1002", "1", "生产钢铁", null, "0", 2));
        menus.add(new Menu("7", "1003", "1", "生产农产品", null, "0", 1));

        menus.add(new Menu("8", "1001001", "1001", "生产苹果", null, "0", 1));
        menus.add(new Menu("9", "1001002", "1001", "生产梨子", null, "0", 1));


        menus.add(new Menu("10", "3001", "3", "管理行政", null, "0", 1));
        menus.add(new Menu("11", "3002", "3", "管理职能", null, "0", 1));
        String trees = JSONObject.toJSONString(getMenuTree(menus));
        System.out.printf(trees);
    }

}
