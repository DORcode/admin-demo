package com.coin.auth.config.shiro;

import com.coin.auth.config.TokenFilter;
import com.coin.auth.util.EncryptUtil;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description: TODO
 * @Author kh
 * @Date 2020/2/28 10:48
 * @Version V1.0
 **/
@Configuration
public class ShiroConfig {

    @Value("${app.encrypt.salt}")
    private String salt;

    @Value("${app.encrypt.iteration}")
    private int iteration;

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter() {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager());
        shiroFilter.setLoginUrl("/api/auth/login/**");
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        // anon,authc,authcBasic,user是第一组认证过滤器
        filterMap.put("/druid/**", "anon");
        filterMap.put("/api/auth/login/**", "anon");
        filterMap.put("/api/auth/logon", "anon");
        filterMap.put("/api/**", "hasToken, authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);

        Map<String, Filter> filters = new HashMap<>();
        filters.put("hasToken", new TokenFilter());
        shiroFilter.setFilters(filters);

        return shiroFilter;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager  securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        shiroRealm.setCachingEnabled(false);
        return shiroRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(iteration);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    public String md5(String pwd) {
        return EncryptUtil.md5(pwd, salt, iteration);
    }
}
