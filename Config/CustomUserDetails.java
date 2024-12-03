package com.example.bookstore.bookstore.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class CustomUserDetails {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Vô hiệu hóa CSRF
                .authorizeHttpRequests(authorize ->
                        authorize
                                .requestMatchers("/register/**").permitAll() // Cho phép truy cập không cần đăng nhập
                                .requestMatchers("/index", "/images/*").permitAll()
                                .requestMatchers("/admin/product/").hasRole("ADMIN") // Chỉ cho phép ADMIN truy cập
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login") // Trang đăng nhập tùy chỉnh
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/products") // Chuyển hướng sau khi đăng nhập thành công
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL logout
                                .permitAll()
                );

        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
