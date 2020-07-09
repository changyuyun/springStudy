package com.ityun.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ityun.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * Shiro配置类
 */
@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     * @param securityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加Shiro内置过滤器
        /**
         * 常用的过滤器
         * anon:无需认证
         * authc:必须认证
         * user:如使用rememberMe的功能可以直接访问
         * perms:该资源必须得到资源权限才可以访问
         * role:该资源必须得到角色权限才可以访问
         */
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        //filterMap.put("/testThymeleaf", "anon");
        filterMap.put("/hello", "authc");
        filterMap.put("/testThymeleaf", "authc");
        filterMap.put("/login", "anon"); //执行登陆的路由无需认证

        //授权过滤器 顺序一定要在/*之前
        filterMap.put("/add", "perms[user:add]");
        filterMap.put("/update", "perms[user:update]");
        filterMap.put("/del", "perms[user:del]");

        filterMap.put("/*", "authc");

        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager
     * @param userRealm
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联realm
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect,用于thymeleaf和shiro标签配合使用
     * @return
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
