package org.demo.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//系统最早的初始化配置，该配置类一般加载的是驱动应用后端的中间层和数据层组件等
@Configuration
@PropertySource(value= { "classpath:application.properties"})
public class RootConfig {
}
