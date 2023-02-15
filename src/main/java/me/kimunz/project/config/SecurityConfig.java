package me.kimunz.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //기본적인 web 보안 활성화
public class SecurityConfig {
    //WebSecurityConfigurerAdapter는 더 이상 사용되지 않는 클래스
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정
                .antMatchers("/api/hello").permitAll() //이 요청은 인증없이 접근 허용
                .anyRequest().authenticated(); //나머지 요청에 대해서는 인증을 받아야 함
        return http.build();
    }
}
