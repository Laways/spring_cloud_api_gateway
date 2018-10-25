package com.imooc.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);//是否支持Cookie跨域
        config.setAllowedOrigins(Arrays.asList("*"));//设置的是哪些原始域,如http://a.com
        config.setAllowedHeaders(Arrays.asList("*"));//设置的是请求头
        config.setAllowedMethods(Arrays.asList("GET", "POST"));
        config.setMaxAge(300l);//设置缓存时间

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
