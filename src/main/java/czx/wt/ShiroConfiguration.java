package czx.wt;

import czx.wt.shiro.AuthRealm;
import czx.wt.shiro.CredentialMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

/**
 * @Description: shiro配置类
 * @Author: ChenZhiXiang
 * @CreateDate: 2018/9/13 0013 14:24
 * @Version: 1.0
 */
@Configuration
public class ShiroConfiguration {

/**
  * @Description: 密码比较器
  * @Author: ChenZhiXiang
  * @CreateDate: 2018/9/13 0013 14:25
  * @Version: 1.0
* */
    @Bean("credentialMatcher")
    public CredentialMatcher credentialMatcher(){
        CredentialMatcher matcher = new CredentialMatcher();
        return matcher;
    }
    /**
      * @Description: 验证
      * @Author: ChenZhiXiang
      * @CreateDate: 2018/9/13 0013 14:28
      * @Version: 1.0
    * */
    @Bean("authRealm")
    public AuthRealm authRealm(@Qualifier("credentialMatcher") CredentialMatcher matcher){
        AuthRealm authRealm = new AuthRealm();
        authRealm.setCredentialsMatcher(matcher);
        return authRealm;
    }
    /**
      * @Description: 配置核心安全事务管理器
      * @Author: ChenZhiXiang
      * @CreateDate: 2018/9/13 0013 14:31
      * @Version: 1.0
    * */
    @Bean("securityManager")
    public SecurityManager securityManager(@Qualifier("authRealm") AuthRealm authRealm){
        DefaultWebSecurityManager  manager = new DefaultWebSecurityManager();
        manager.setRealm(authRealm);
        //用户授权/认证信息Cache, 采用EhCache缓存
        manager.setCacheManager(ehCacheManager());
        return manager;
    }
    /**
     * 配置shiro跟spring的关联
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
    /**
     * Spring的一个bean , 由Advisor决定对哪些类的方法进行AOP代理 .
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    /**
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中：
     * 1、安全管理器：securityManager
     * 可见securityManager是整个shiro的核心；
     *
     * @return
     */
    @Bean
    public EhCacheManager ehCacheManager() {
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:config/ehcache.xml");
        return cacheManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager")SecurityManager securityManager){

        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置securityManager
        bean.setSecurityManager(securityManager);
        //设置登录页面
        bean.setLoginUrl("/login");
        //设置登录成功跳转的页面
        bean.setSuccessUrl("/index.html");
        //设置未授权跳转的页面
        /*bean.setUnauthorizedUrl("/unauthorized.html");*/
        //定义过滤器
        LinkedHashMap<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        //anon匿名访问，不需要认证。
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/bootstrap-3.3.7/**", "anon");
        filterChainDefinitionMap.put("/loginUser", "anon");
        //图片请求
        filterChainDefinitionMap.put("/gif/getGifCode","anon");
        //需要登录访问的资源 , 一般将/**放在最下边
        filterChainDefinitionMap.put("/**", "authc");
        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return bean;
    }
}
