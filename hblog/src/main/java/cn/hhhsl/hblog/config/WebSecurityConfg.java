package cn.hhhsl.hblog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class WebSecurityConfg extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/signin");
        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**","/img/**","/font/**",  "/api/**").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/recommend").permitAll()
                .antMatchers("/daily").permitAll()
                .antMatchers("/note").permitAll()
                .antMatchers("/signin").permitAll()
                .antMatchers("/500").permitAll()
                .antMatchers("/403").permitAll()
                .antMatchers("/404").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/admin/recommend").hasRole("ADMIN")
                .antMatchers("/admin/daily").hasRole("ADMIN")
                .antMatchers("/admin/note").hasRole("ADMIN")
                .anyRequest() //任何其它请求
                .authenticated() //都需要身份认证
                .and()
                .formLogin() //使用表单认证方式
                .loginProcessingUrl("/signin")//配置默认登录入口
                .and()
                .csrf().disable();
    }

}
