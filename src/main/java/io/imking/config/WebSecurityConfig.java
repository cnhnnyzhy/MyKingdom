package io.imking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import io.imking.admin.service.CustomUserDetailsService;

/**
 * Spring Security 配置类
 *
 * @author ocean
 * @date 2017/11/11
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问"/"和"/login"
        http.authorizeRequests().antMatchers("/", "/admin/login").permitAll()
                //其他地址的访问均需验证权限
                .anyRequest().authenticated()
                //指定登录页是"/login"
                .and().formLogin().loginPage("/admin/login")
                //登录成功后默认跳转到"/index"
                .defaultSuccessUrl("/admin/index").permitAll()
                //退出登录后的默认url是"/login"
                .and().logout().logoutSuccessUrl("/admin/login").permitAll();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService())
                .passwordEncoder(passwordEncoder());
    }



    /**
     * 设置用户密码的加密方式为MD5加密
     * @return
     */
    @Bean
    public Md5PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();
    }

    /**
     * 自定义UserDetailsService，从数据库中读取用户信息
     * @return
     */
    @Bean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }




}
