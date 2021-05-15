package com.niu.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置忽略的文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//        设置验证每个请求，除了排除的那些URL
                .authorizeRequests()
                .antMatchers("/content/**", "/addUser", "/getAllArticles"
                        , "/searchArticle", "/searchUser", "/displayArticle","/getArticlesByUser").permitAll()
                .anyRequest().authenticated()
                .and()
//        设置基于表单验证，登录页面为“/login”对应的视图文件
                .formLogin()
                .loginPage("/login").permitAll();
    }


}