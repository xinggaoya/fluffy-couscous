package com.example.shiro_demo.aop;

import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: XingGao
 * @Date: 2022/03/24 14:32
 * @Description:
 */

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();

        //关联 DefaultWebSecurityManager
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        //添加shiro内置的过滤器
        /*
         * anon: 无需认证就可以访问
         * auth: 必须认证才能访问
         * user: 必须拥有记住我功能才能用
         * perms: 拥有对某个资源的权限才能访问
         * role: 拥有某个角色权限才能访问
         * */
        //添加过滤器
        Map<String, Filter> filters=new HashMap<>();
        filters.put("auth",new AuthFilter());        //自定义的认证授权过滤器
        shiroFilterFactoryBean.setFilters(filters);  //添加自定义的认证授权过滤器

        //要拦截的路径放在map里面
        Map<String,String> filterMap= new LinkedHashMap<>();
        filterMap.put("/user/login","anon");  //放行login接口
        filterMap.put("/show","anon");  //放行login接口
        filterMap.put("/test","role");  //放行login接口
        filterMap.put("/logout","anon");    //放行logout接口
        filterMap.put("/**","auth");    //拦截所有路径, 它自动会跑到 AuthFilter这个自定义的过滤器里面
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    //配置securityManager的实现类，变向的配置了securityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(AuthRealm authRealm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();

        //关联realm
        defaultWebSecurityManager.setRealm(authRealm);

        /*
         * 关闭shiro自带的session
         */
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        defaultWebSecurityManager.setSubjectDAO(subjectDAO);
        return defaultWebSecurityManager;
    }

    // 将自定义realm注入到 DefaultWebSecurityManager
    @Bean
    public AuthRealm authRealm(){
        return new AuthRealm();
    }


    // 通过调用Initializable.init()和Destroyable.destroy()方法,从而去管理shiro bean生命周期
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    //开启shiro权限注解
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager defaultWebSecurityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(defaultWebSecurityManager);
        return advisor;
    }
}
