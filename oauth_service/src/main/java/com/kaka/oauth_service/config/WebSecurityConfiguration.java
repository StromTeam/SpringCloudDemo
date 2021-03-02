package com.kaka.oauth_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 注解权限拦截
 * Spring Web Security 的配置类 :
 * 1. 使用一个 WebSecurity 对象基于安全配置创建一个 FilterChainProxy 对象来对用户请求进行安全过滤。
 * 2. 也会暴露诸如 安全SpEL表达式处理器 SecurityExpressionHandler 等一些类。
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String finalPassword = "{bcrypt}"+bCryptPasswordEncoder.encode("123456");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user_1").password(finalPassword).authorities("USER").build());
        manager.createUser(User.withUsername("user_2").password(finalPassword).authorities("USER").build());

        return manager;
    }

    /**
     * 认证服务器需配合Security使用
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        AuthenticationManager manager = super.authenticationManagerBean();
        return manager;
    }

    /**
     * Security 用户密码和认证服务器客户端密码都需要加密算法
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    /**
     * 验证用户权限
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //方法有很多子方法，每个子匹配器将会按照声明的顺序起作用。
            .authorizeRequests()
                //配置路径拦截，表明路径访问所对应的权限，其他路径都需要认证。
                .antMatchers("/oauth/**","/login/**", "/home").permitAll()
                .anyRequest()
                .authenticated()
                .and()
            //对应表单认证相关的配置
            .formLogin()
                //指定该路径为登录页面，当未认证的用户尝试访问任何受保护的资源时，都会跳转到该路径
                .loginPage("/login")
                .failureForwardUrl("/login?error")
                .permitAll()
                .and()
            //对应了注销相关的配置
            .logout()
                .logoutUrl("/login")
                .logoutSuccessUrl("/index")
                .permitAll();
    }


    //设置不拦截资源服务器的认证请求
    @Override
    public void configure(WebSecurity web) throws Exception {
        // /oauth/check_token 这个走basic认证保护
        web
            .ignoring()
            .antMatchers(
                    "/oauth/check_token",
                                 "/css/**",
                                 "/js/**",
                                 "/plugins/**",
                                 "/favicon.ico");
    }


}
