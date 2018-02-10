package com.developerstack.config;

import com.developerstack.service.impl.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/*.js/**").addResourceLocations("/resources/static/");
        registry.addResourceHandler("/*.css/**").addResourceLocations("/resources/static/")
                .addResourceLocations("/resources/signin/")
                .addResourceLocations("/resources/css/");
        registry.addResourceHandler("/*.jpg/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/*.png/**").addResourceLocations("/resources/images/");
        registry.addResourceHandler("/*.ttf/**").addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/*.eot*/**").addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/*.wolf*/**").addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/*.wolf2*/**").addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/*.svg*/**").addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/*.otf*/**").addResourceLocations("/resources/fonts/");
    }
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
    }

    @Bean
    public UserDetailServiceImpl userDetailService(){
        return new UserDetailServiceImpl();
    }

    @Bean
    public InternalResourceViewResolver setupViewResolver()  {
        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
        resolver.setPrefix ("/WEB-INF/ui/jsp/");
        resolver.setSuffix (".jsp");
        resolver.setViewClass (JstlView.class);
        return resolver;
    }

}
