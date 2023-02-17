package me.kimunz.project.config;

import me.kimunz.project.jwt.JwtAccessDeniedHandler;
import me.kimunz.project.jwt.JwtAuthenticationEntryPoint;
import me.kimunz.project.jwt.JwtSecurityConfig;
import me.kimunz.project.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity //기본적인 web 보안 활성화
@EnableGlobalMethodSecurity(prePostEnabled = true) //@PreAuthorize 어노테이션을 메소드단위로 추가하기 위해 적용
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(
            TokenProvider tokenProvider,
            JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
            JwtAccessDeniedHandler jwtAccessDeniedHandler
    ) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //WebSecurityConfigurerAdapter는 더 이상 사용되지 않는 클래스
    //아래처럼 빈으로 등록해줘야함
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()

                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                //h2-console을 위한 설정
                .and()
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests() //HttpServletRequest를 사용하는 요청들에 대한 접근제한을 설정
                .antMatchers("/api/hello").permitAll() //이 요청은 인증없이 접근 허용
                .antMatchers("/api/authenticate").permitAll() //이 요청은 인증없이 접근 허용
                .antMatchers("/api/signup").permitAll() //이 요청은 인증없이 접근 허용
                .anyRequest().authenticated() //나머지 요청에 대해서는 인증을 받아야 함

                .and()
                .apply(new JwtSecurityConfig(tokenProvider));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .antMatchers("/h2-console/**", "/favicon.ico");
    }
}
