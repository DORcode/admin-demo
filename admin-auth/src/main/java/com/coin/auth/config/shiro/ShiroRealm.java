package com.coin.auth.config.shiro;

import com.coin.auth.util.ResultCodeEnum;
import com.coin.auth.web.entity.SysUser;
import com.coin.auth.web.service.SysPermissionService;
import com.coin.auth.web.service.SysRoleService;
import com.coin.auth.web.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.Set;

/**
 * @ClassName ShiroRealm
 * @Description: TODO
 * @Author kh
 * @Date 2020/2/26 16:38
 * @Version V1.0
 **/
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysPermissionService sysPermissionService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();

        //查询角色
        Set<String> roles = sysRoleService.selectSysRoleNamesByUserId(user.getId());

        //查询权限
        Set<String> permissions = sysPermissionService.selectPermissionsByUserId(user.getId());


        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if(CollectionUtils.isNotEmpty(roles)) {
            info.setRoles(roles);
        }
        if(CollectionUtils.isNotEmpty(permissions)) {
            info.setStringPermissions(permissions);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken auth = (UsernamePasswordToken) authenticationToken;
        SysUser sysUser = sysUserService.selectOneSelective(new SysUser(auth.getUsername()));
        if(null == sysUser) {
            throw  new AccountException();
        }

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(sysUser, sysUser.getPassword(),
                ByteSource.Util.bytes(""), "realm");
        return info;
    }
}
