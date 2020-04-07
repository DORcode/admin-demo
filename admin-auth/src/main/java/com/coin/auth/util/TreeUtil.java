package com.coin.auth.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coin.auth.web.vo.Menu;
import com.coin.auth.web.vo.SysPermissionVo;
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
//                Menu temp = new Menu();
//                BeanUtil.copyProperties(temp, m);
                m.setSubMenus(getChildMenu(list, m));
                menus.add(m);
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

    public static List<SysPermissionVo> getSysPermissionTree(List<SysPermissionVo> list) {
        List<SysPermissionVo> perms = new ArrayList<>();
        for(SysPermissionVo perm : list) {
            if(StringUtils.isEmpty(perm.getPCode())) {
//                SysPermissionVo temp = new SysPermissionVo();
//                BeanUtil.copyProperties(temp, perm);
                perm.setSubPerms(getChildSysPermission(list, perm));
                perms.add(perm);
            }
        }
        return perms;
    }

    private static List<SysPermissionVo> getChildSysPermission(List<SysPermissionVo> list, SysPermissionVo perm) {
        List<SysPermissionVo> subPerms = new ArrayList<>();
        for(SysPermissionVo p : list) {
            if(perm.getCode().equals(p.getPCode())) {
                p.setSubPerms(getChildSysPermission(list, p));
                subPerms.add(p);
            }
        }
        return subPerms;
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
        System.out.println(trees);

        List<SysPermissionVo> perms = new ArrayList<>();
        perms.add(new SysPermissionVo("1", "1", null, "生产", null, "0", 1));
        perms.add(new SysPermissionVo("2", "2", null, "消费", null, "0", 2));
        perms.add(new SysPermissionVo("3", "3", null, "管理", null, "0", 3));
        perms.add(new SysPermissionVo("4", "4", null, "工厂", null, "0", 4));
        perms.add(new SysPermissionVo("5", "1001", "1", "生产水果", null, "0", 1));
        perms.add(new SysPermissionVo("6", "1002", "1", "生产钢铁", null, "0", 2));
        perms.add(new SysPermissionVo("7", "1003", "1", "生产农产品", null, "0", 1));
        perms.add(new SysPermissionVo("8", "1001001", "1001", "生产苹果", null, "0", 1));
        perms.add(new SysPermissionVo("9", "1001002", "1001", "生产梨子", null, "0", 1));
        perms.add(new SysPermissionVo("10", "3001", "3", "管理行政", null, "0", 1));
        perms.add(new SysPermissionVo("11", "3002", "3", "管理职能", null, "0", 1));
        System.out.println("1 = " + 1);
        String str = JSONObject.toJSONString(getSysPermissionTree(perms));
        System.out.println(str);
    }

}
