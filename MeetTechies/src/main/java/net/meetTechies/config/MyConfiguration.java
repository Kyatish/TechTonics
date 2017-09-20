/*package net.meetTechies.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//package net.meetTechies.config;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class MyConfiguration {

    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin("*");
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));
        config.setExposedHeaders(Arrays.asList("Cache-Control", "Content-Language", "Content-Type", "Expires", "Last-Modified", "Pragma"));
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }
}

@Configuration
public class MyConfiguration {

//This can be used in combination with @CrossOrigin on the controller & method.

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("OPTIONS","POST","GET")
                        .allowedHeaders("Origin", "X-Requested-With", "Content-Type", "Accept","Access-Control-Request-Method,"
                        		+ "Access-Control-Request-Headers","Authorization")
                        .allowedOrigins("http//:localhost:9191")
                        .allowCredentials(false)
                        .maxAge(3600)
                        .exposedHeaders("Cache-Control", "Content-Language", "Content-Type", "Expires", "Last-Modified", "Pragma");
               
            }
        };
    }
}*/