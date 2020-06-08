package org.demo.mvc.config;

import javax.servlet.Filter;

import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import brave.dubbo.rpc.TraceApplicationListener;
import brave.dubbo.rpc.TraceAutoConfiguration;
import brave.spring.webmvc.DelegatingTracingFilter;

/**
 * Indirectly invoked by {@link SpringServletContainerInitializer} in a Servlet
 * 3+ container 它自动被加载，负责应用程序中 servlet 上下文中的 DispatcherServlet 和 Spring 其他上下文的配置
 */
public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	// 指定根配置类,RootConfig配置类加载的是驱动应用后端的中间层和数据层组件，是父上下文
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class, TraceAutoConfiguration.class };
	}

	// 指定配置类,WebConfig配置类中主要是内容是启用组件扫描，配置视图解析器，配置静态资源的处理
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class, TraceApplicationListener.class };
	}

	// setup mapping
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	// setup DelegatingTracingFilter(from brave)
	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { new DelegatingTracingFilter() };
	}
}