package org.demo.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc //开启 Spring MVC 支持（@EnableWebMvc 注解（JavaConfig）：和 @Configuration 注解一起使用）
@ComponentScan({"org.demo.**"})//注解扫描
public class WebConfig extends WebMvcConfigurerAdapter {
	//非必须配置项，如需viewResolver则配置该项
	@Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

	// config ServletHandling 默认 Servlet 处理 (详见方法注释)
	//如果 Sping 遇到没有 mapping 的 url 地址，就会转发到默认的 Servlet 处理（如 tomcat）。这其中就包括静态文件（前提是你没有为静态文件设置 RequestMapping）
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();// 开启默认转发
    }
    
	/**
	 *   必须注册RestTemplate作为一个bean，以便拦截器被注入
	 */
	@Bean
	RestTemplate restTemplate() {
	    return new RestTemplate();
	}
    
}